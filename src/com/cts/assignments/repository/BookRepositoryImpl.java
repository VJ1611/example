package com.cts.assignments.repository;

import com.cts.assignments.cts.assignments.util.FileUtil;
import com.cts.assignments.domain.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository{

    private String fileName = "book.ser";

    /**
     * This method will add a serialized book
     * @param book
     */
    @Override
    public void add(Book book) {
        try {
            List<Book> list = new ArrayList<>();
            list.add(book);
            writeDataToFile(list, true);
            System.out.println("Successfully created ");
        } catch (IOException e) {
            System.out.println("Exception occured while writing data" + e.getMessage());
        }
    }

    /**
     * This method will search a particular book
     * @param bookId
     * @return book
     */
    @Override
    public Book search(long bookId) {
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        boolean cont = true;
        try {
            fileIn = new FileInputStream(fileName);

            while (cont) {
                try {
                    in = new ObjectInputStream(fileIn);
                    Book obj = (Book) in.readObject();
                    if (obj != null) {

                        if (obj.getBookId() == bookId) {
                            System.out.println("Book found");
                            return obj;
                        }
                    } else {
                        cont = false;
                    }
                } catch (EOFException eof) {
                    cont = false;
                }
            }

        } catch (Exception e) {
            System.out.println("Exception occured while reading data" + e.getMessage());
        } finally {
            FileUtil.closeReadObjects(fileIn, in);

        }

        return null;
    }

    /**
     * This method will delete the book
     * @param bookId
     * @return
     */
    @Override
    public int delete(long bookId) {

        List<Book> list = new ArrayList<Book>();
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        boolean cont = true;
        Book obj = null;
        try {
            fileIn = new FileInputStream(fileName);

            while (cont) {
                try {
                    in = new ObjectInputStream(fileIn);
                    obj = (Book) in.readObject();
                    if (obj != null) {
                        System.out.println(obj.getBookId());
                        if (obj.getBookId() != bookId) {
                            list.add(obj);
                        }
                    } else {
                        cont = false;
                    }
                } catch (EOFException eof) {
                    cont = false;
                }
            }
            FileUtil.closeReadObjects(fileIn, in);
            if (obj != null) {
                writeDataToFile(list, false);
                System.out.println("Successfully deleted a book");
            } else {
                return 1;
            }

        } catch (IOException e) {
            System.out.println("Exception occured while reading data" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Exception occured while reading data" + e.getMessage());
        } finally {
            FileUtil.closeReadObjects(fileIn, in);

        }

        return 0;
    }


    private void writeDataToFile(List<Book> list, boolean append) throws IOException {
        FileOutputStream fileOut = null;
        ObjectOutputStream objectOut = null;

        try {
            fileOut = new FileOutputStream(new File(fileName), append);

            for (Book book : list) {
                objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(book);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            FileUtil.closewriteObjects(fileOut, objectOut);

        }


    }

}

package com.cts.assignments.repository;

import com.cts.assignments.cts.assignments.util.FileUtil;
import com.cts.assignments.domain.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryImpl implements  SubjectRepository {

    private String fileName = "subject.ser";

    /**
     * This method will add a serialized book
     * @param subject
     */
    @Override
    public void add(Subject subject) {
        try {
            List<Subject> list = new ArrayList<>();
            list.add(subject);
            writeDataToFile(list, true);
            System.out.println("Successfully created ");
        } catch (IOException e) {
            System.out.println("Exception occured while writing data " + e.getMessage());
        }
    }

    /**
     * This method will search a particular book
     * @param subjectId
     * @return subject
     */
    @Override
    public Subject search(long subjectId) {
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        boolean cont = true;
        try {
            fileIn = new FileInputStream(fileName);

            while (cont) {
                try {
                    in = new ObjectInputStream(fileIn);
                    Subject obj = (Subject) in.readObject();
                    if (obj != null) {
                        if (obj.getSubjectId() == subjectId) {
                            System.out.println("Subject found");
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
            System.out.println("Exception occured while reading data " + e.getMessage());
        } finally {
            FileUtil.closeReadObjects(fileIn, in);

        }

        return null;
    }

    /**
     * This method will delete the book
     * @param subjectId
     * @return
     */
    @Override
    public int delete(long subjectId) {

        List<Subject> list = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        boolean cont = true;
        Subject obj = null;
        try {
            fileIn = new FileInputStream(fileName);

            while (cont) {
                try {
                    in = new ObjectInputStream(fileIn);
                    obj = (Subject) in.readObject();
                    if (obj != null) {
                        if (obj.getSubjectId() != subjectId) {
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


    private void writeDataToFile(List<Subject> list, boolean append) throws IOException {
        FileOutputStream fileOut = null;
        ObjectOutputStream objectOut = null;

        try {
            fileOut = new FileOutputStream(new File(fileName), append);

            for (Subject subject : list) {
                objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(subject);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            FileUtil.closewriteObjects(fileOut, objectOut);

        }

    }

}

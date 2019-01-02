package com.cts.assignments;


import com.cts.assignments.bl.BookMananger;
import com.cts.assignments.bl.SubjectManager;
import com.cts.assignments.domain.Book;
import com.cts.assignments.domain.Subject;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Assignment {

    public static void getOption() {
        Scanner input = new Scanner (System.in);
        char choice;
        do {

            System.out.println("a. Add a Subject \nb. Add a Book\nc. Delete a Subject\n" +
                    "d. Delete a book\ne. Search for a book\nf. Search for a subject\ng. Exit\n");
            String option = input.next();

            choice = option.charAt(0);

            long bookId = 0;
            long subjectId = 0;
            //add a switch statement
            switch(choice)
            {
                case 'a':

                Subject subject = new Subject();
                System.out.println("Enter the subject Id");

                subject.setSubjectId(input.nextLong());
                System.out.println("Enter the Subject title");
                subject.setSubtitle(input.next());
                System.out.println("Enter the subject duration");
                subject.setDurationInHours(input.nextInt());
                System.out.println("Do you want to add references ? Y/N");
                String status = input.next();
                if(status != null && "Y".equalsIgnoreCase(status)) {
                    Set<Book> references = new HashSet<>();
                    boolean flag = true;
                    while(flag) {
                        Book book = new Book();
                        System.out.println("Enter the book Id");

                        book.setBookId(input.nextLong());
                        System.out.println("Enter the book title");
                        book.setTitle(input.next());
                        System.out.println("Enter the book price");
                        book.setPrice(input.nextDouble());
                        System.out.println("Enter the book volume");
                        book.setVolume(input.nextInt());
                        System.out.println("Enter the book publish date");
                        String date = input.next();
                        references.add(book);
                        System.out.println("Do you want to add one more book ? Y/N");
                        status = input.next();
                        if(status != null && "N".equalsIgnoreCase(status)) flag = false;
                    }
                    subject.setReferences(references);
                } else {
                    subject.setReferences(null);
                }

                new SubjectManager().addSubject(subject);
                break;

                case 'b':

                    Book book = new Book();
                    System.out.println("Enter the book Id");

                    book.setBookId(input.nextLong());
                    System.out.println("Enter the book title");
                    book.setTitle(input.next());
                    System.out.println("Enter the book price");
                    book.setPrice(input.nextDouble());
                    System.out.println("Enter the book volume");
                    book.setVolume(input.nextInt());
                    System.out.println("Enter the book publish date");
                    String date = input.next();
                    new BookMananger().addBook(book);
                    break;

                case 'c':
                    System.out.println("Enter the subject Id for delete");
                    subjectId = input.nextLong();
                    new SubjectManager().delete(subjectId);
                    break;
                case 'd':
                    System.out.println("Enter the book Id for delete");
                    bookId = input.nextLong();
                    new BookMananger().delete(bookId);
                    break;
                case 'e':
                    System.out.println("Enter the book Id for search");
                    bookId = input.nextLong();
                    new BookMananger().search(bookId);
                    break;
                case 'f':
                    System.out.println("Enter the Subject Id for search");
                    subjectId = input.nextLong();
                    new SubjectManager().search(subjectId);
                    break;


            }
        } while (choice != 'g');

        System.out.println("exit");
    }

    public static void main(String args[]) {

    getOption();


    }
}

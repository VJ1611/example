package com.cts.assignments.bl;


import com.cts.assignments.domain.Book;
import com.cts.assignments.repository.BookRepositoryImpl;

public class BookMananger {

    public String addBook(Book book) {
        BookRepositoryImpl bookRepository =  new BookRepositoryImpl();
        bookRepository.add(book);
        return "Successfully added Book :: " ;
    }

    public void search(long bookId) {
        BookRepositoryImpl bookRepository =  new BookRepositoryImpl();
        Book book = bookRepository.search(bookId);
        if(book != null) {
            System.out.println("Book Details :: " + book.toString());
        } else {
            System.out.println("Book not found for this id :: " + bookId);
        }
    }

    public void delete(long bookId) {
        BookRepositoryImpl bookRepository =  new BookRepositoryImpl();
        int status = bookRepository.delete(bookId);
        if (status > 0) {
            System.out.println("Book not found for this id ::" +bookId);

        } else {
            System.out.println("Book deleted successfully" );
        }
    }
}

package com.cts.assignments.repository;

import com.cts.assignments.domain.Book;

public interface BookRepository {

    public void add(Book book);

    public Book search(long bookId);

    public int delete(long bookId);
}

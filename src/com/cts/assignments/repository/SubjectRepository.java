package com.cts.assignments.repository;


import com.cts.assignments.domain.Subject;

public interface SubjectRepository {

    public void add(Subject subject);

    public Subject search(long bookId);

    public int delete(long subjectId);
}

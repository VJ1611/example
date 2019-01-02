package com.cts.assignments.bl;


import com.cts.assignments.domain.Subject;

import com.cts.assignments.repository.SubjectRepositoryImpl;

public class SubjectManager {

    public String addSubject(Subject subject) {
        SubjectRepositoryImpl subjectRepository =  new SubjectRepositoryImpl();
        subjectRepository.add(subject);
        return "Successfully added subject :: " ;
    }

    public void search(long subjectId) {
        SubjectRepositoryImpl subjectRepository =  new SubjectRepositoryImpl();
        Subject subject = subjectRepository.search(subjectId);
        if(subject != null) {
            System.out.println("Subject Details :: " + subject.toString());
        } else {
            System.out.println("Subject not found for this id :: " + subjectId);
        }
    }

    public void delete(long subjectId) {
        SubjectRepositoryImpl subjectRepository =  new SubjectRepositoryImpl();
        int status = subjectRepository.delete(subjectId);
        if (status > 0) {
            System.out.println("Subject not found for this id ::" +subjectId);

        } else {
            System.out.println("Subject deleted successfully" );
        }
    }
}

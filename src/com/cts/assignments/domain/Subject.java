package com.cts.assignments.domain;

import java.io.Serializable;
import java.util.Set;

public class Subject implements Serializable {

    private long subjectId;

    private String subtitle;

    private int durationInHours;

    private Set<Book> references;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    public Set<Book> getReferences() {
        return references;
    }

    public void setReferences(Set<Book> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subtitle='" + subtitle + '\'' +
                ", durationInHours=" + durationInHours +
                ", references=" + references +
                '}';
    }
}

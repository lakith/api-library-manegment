package com.finalproj.finalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "manuscript")
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int manuscriptId;
    private String manuscriptName;
    private int year;

    public Manuscript() {
    }

    public int getManuscriptId() {
        return manuscriptId;
    }

    public void setManuscriptId(int manuscriptId) {
        this.manuscriptId = manuscriptId;
    }

    public String getManuscriptName() {
        return manuscriptName;
    }

    public void setManuscriptName(String manuscriptName) {
        this.manuscriptName = manuscriptName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

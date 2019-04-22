package com.finalproj.finalproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "manuscript")
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int manuscriptId;

    @NotNull
    private String manuscriptName;

    private int year;

    @NotNull
    @Pattern(regexp = "^(rare)$", message= "Input must be 'rare'")
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

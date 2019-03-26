package com.finalproj.finalproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "newsPaper")
@XmlRootElement
public class NewsPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int newsPaperId;
    @NotNull
    private String newsPaperName;
    @NotNull
    private Date issueDate;
    @NotNull
    private String status;

    public NewsPaper() {
    }

    public int getNewsPaperId() {
        return newsPaperId;
    }

    public void setNewsPaperId(int newsPaperId) {
        this.newsPaperId = newsPaperId;
    }

    public String getNewsPaperName() {
        return newsPaperName;
    }

    public void setNewsPaperName(String newsPaperName) {
        this.newsPaperName = newsPaperName;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

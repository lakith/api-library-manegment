package com.finalproj.finalproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Magazine")
public class Magazine{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int magazineId;
    private String magazineName;
    private Date date;
    private String status;

    public Magazine() {
    }

    public int getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(int magazineId) {
        this.magazineId = magazineId;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

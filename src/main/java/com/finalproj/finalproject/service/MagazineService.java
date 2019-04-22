package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.Magazine;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface MagazineService {

    ResponseEntity<?> saveMagazine(Magazine magazine);
    ResponseEntity<?> updateMagazine(int magazineId,Magazine magazine);
    ResponseEntity<?> getMagazine(int magazineId);
    ResponseEntity<?> deleteMagazine(int magazineId);
    ResponseEntity<?> getAllMagazines();
    ResponseEntity<?> getMagazineByDate(Date startDate, Date endDate);
    ResponseEntity<?> getMagazineByName(String name);
    ResponseEntity<?> getMagazineByStatus(String name);

}

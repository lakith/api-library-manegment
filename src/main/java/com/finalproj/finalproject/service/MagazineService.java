package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.Magazine;
import org.springframework.http.ResponseEntity;

public interface MagazineService {

    public ResponseEntity<?> saveMagazine(Magazine magazine);
    public ResponseEntity<?> updateMagazine(int magazineId,Magazine magazine);
    public ResponseEntity<?> getMagazine(int magazineId);
    public ResponseEntity<?> deleteMagazine(int magazineId);
    public ResponseEntity<?> getAllMagazines();

}

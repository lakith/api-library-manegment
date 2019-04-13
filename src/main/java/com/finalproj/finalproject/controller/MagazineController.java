package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.model.Magazine;
import com.finalproj.finalproject.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/magazines")
@CrossOrigin
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @PostMapping()
    public ResponseEntity<?> saveMagazine(@Valid @RequestBody Magazine magazine) {
        return magazineService.saveMagazine(magazine);
    }

    @PutMapping("/{magazineId}")
    public ResponseEntity<?> updateMagazine(@Valid @PathVariable int magazineId, @RequestBody Magazine magazine) {
        return magazineService.updateMagazine(magazineId,magazine);
    }

    @DeleteMapping("/{magazineId}")
    public ResponseEntity<?> deleteMagazine(@PathVariable int magazineId) {
        return magazineService.deleteMagazine(magazineId);
    }

    @GetMapping("/{magazineId}")
    public ResponseEntity<?> getMagazine(@PathVariable int magazineId) {
        return magazineService.getMagazine(magazineId);
    }

    @GetMapping()
    public ResponseEntity<?> getMagazines() {
        return magazineService.getAllMagazines();
    }


}

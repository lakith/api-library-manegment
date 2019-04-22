package com.finalproj.finalproject.service.impl;

import com.finalproj.finalproject.model.Book;
import com.finalproj.finalproject.model.Magazine;
import com.finalproj.finalproject.model.ResponseModel;
import com.finalproj.finalproject.repository.MagazinesRepository;
import com.finalproj.finalproject.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    private MagazinesRepository magazinesRepository;

    @Override
    public ResponseEntity<?> saveMagazine(Magazine magazine) {

        ResponseModel responseModel = new ResponseModel();
        magazine = magazinesRepository.save(magazine);

        try {
            if (magazine != null) {
                responseModel.setMessage("Magazine Saved Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
            }else{
                responseModel.setMessage("Failed To Save Magazine");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Save Magazine");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateMagazine(int magazineId, Magazine magazine) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Magazine> optionalMagazine = magazinesRepository.findById(magazineId);

            if (!optionalMagazine.isPresent()){
                responseModel.setMessage("There's No Magazine Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            magazine.setMagazineId(optionalMagazine.get().getMagazineId());

            magazine = magazinesRepository.save(magazine);

            if (magazine != null) {
                responseModel.setMessage("Magazine Details Updated Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            }else{
                responseModel.setMessage("Failed To Update Magazine");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Update Magazine");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getMagazine(int magazineId) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Magazine> optionalMagazine = magazinesRepository.findById(magazineId);

            if (!optionalMagazine.isPresent()){
                responseModel.setMessage("There's No Magazine  Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(optionalMagazine.get(),HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Failed To Retrieve Magazine");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteMagazine(int magazineId) {

        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Magazine> optionalMagazine = magazinesRepository.findById(magazineId);

            if (!optionalMagazine.isPresent()){
                responseModel.setMessage("There's  No Magazine Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            magazinesRepository.deleteById(optionalMagazine.get().getMagazineId());
            responseModel.setMessage("Magazine Removed Successfully");
            responseModel.setStatus(true);
            return new ResponseEntity<>(responseModel,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Failed To Delete Magazine");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getMagazineByDate(Date startDate,Date endDate) {
        List<Magazine> magazineList = magazinesRepository.getMagazinesByDate(startDate,endDate);
        if(magazineList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(magazineList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getMagazineByName(String name) {
        List<Magazine> magazineList = magazinesRepository.getMagazinesByName(name);
        if(magazineList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(magazineList,HttpStatus.OK);
        }
    }

    @SuppressWarnings("Duplicates")
    public ResponseEntity<?> getMagazineByStatus(String name) {
        List<Magazine> magazineList = magazinesRepository.getMagazinesByName(name);
        if(magazineList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(magazineList,HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getAllMagazines() {

        ResponseModel responseModel = new ResponseModel();

        try {
            List<Magazine> list= new ArrayList<>();
            list=magazinesRepository.findAll();

            if (list.isEmpty()){
                responseModel.setStatus(false);
                responseModel.setMessage("Nothing  Found");
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(list,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Nothing Found ");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }
}

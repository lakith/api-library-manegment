package com.finalproj.finalproject.service.impl;

import com.finalproj.finalproject.model.Manuscript;
import com.finalproj.finalproject.model.ResponseModel;
import com.finalproj.finalproject.repository.ManuscriptRepository;
import com.finalproj.finalproject.service.ManuscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManuscriptServiceImpl implements ManuscriptService {

    @Autowired
    private ManuscriptRepository manuscriptRepository;

    @Override
    public ResponseEntity<?> saveManuscript(Manuscript manuscript) {

        ResponseModel responseModel = new ResponseModel();
        manuscript=manuscriptRepository.save(manuscript);

        try {
            if (manuscript != null) {
                responseModel.setMessage("Manuscript Saved Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
            }else{
                responseModel.setMessage("Failed To Save Manuscript");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Save Manuscript");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> updateManuscript(int manuscriptId, Manuscript manuscript) {

        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Manuscript> manuscriptOptional = manuscriptRepository.findById(manuscriptId);

            if (!manuscriptOptional.isPresent()){
                responseModel.setMessage("There's No Manuscript Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            manuscript.setManuscriptId(manuscriptOptional.get().getManuscriptId());

            manuscript = manuscriptRepository.save(manuscript);

            if (manuscript != null) {
                responseModel.setMessage("Manuscript Details Updated Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            }else{
                responseModel.setMessage("Failed To Update Manuscript");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Update Manuscript");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getManuscript(int manuscriptId) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Manuscript> manuscriptOptional = manuscriptRepository.findById(manuscriptId);

            if (!manuscriptOptional.isPresent()){
                responseModel.setMessage("There's No Manuscript  Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(manuscriptOptional.get(),HttpStatus.OK);


        } catch (Exception e) {
            responseModel.setMessage("Failed To Retrieve Manuscript");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteManuscript(int manuscriptId) {

        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Manuscript> manuscriptOptional = manuscriptRepository.findById(manuscriptId);

            if (!manuscriptOptional.isPresent()){
                responseModel.setMessage("There's No Manuscript Exists ");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            manuscriptRepository.deleteById(manuscriptOptional.get().getManuscriptId());
            responseModel.setMessage("Manuscript Removed Successfully");
            responseModel.setStatus(true);
            return new ResponseEntity<>(responseModel,HttpStatus.OK);


        } catch (Exception e) {
            responseModel.setMessage("Failed To Delete Manuscript");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllManuscripts() {
        ResponseModel responseModel = new ResponseModel();

        try {
            List<Manuscript> list= new ArrayList<>();
            list=manuscriptRepository.findAll();

            if (list.isEmpty()){
                responseModel.setStatus(false);
                responseModel.setMessage("Nothing Found ");
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

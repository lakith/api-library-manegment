package com.finalproj.finalproject.service.impl;

import com.finalproj.finalproject.model.NewsPaper;
import com.finalproj.finalproject.model.ResponseModel;
import com.finalproj.finalproject.repository.NewsPaperRepository;
import com.finalproj.finalproject.service.NewsPaperService;
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
public class NewsPaperServiceImpl implements NewsPaperService {

    @Autowired
    private NewsPaperRepository newsPaperRepository;

    @Override
    public ResponseEntity<?> saveNewsPaper(NewsPaper newsPaper) {
        ResponseModel responseModel = new ResponseModel();
        newsPaper = newsPaperRepository.save(newsPaper);

        try {
            if (newsPaper != null) {
                responseModel.setMessage("News Paper Saved Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
            }else{
                responseModel.setMessage("Failed To Save News Paper");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Save News Paper");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> updateNewsPaper(int newsPaperId, NewsPaper newsPaper) {

        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<NewsPaper> newsPaperOptional = newsPaperRepository.findById(newsPaperId);

            if (!newsPaperOptional.isPresent()){
                responseModel.setMessage("There's No News Paper Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            newsPaper.setNewsPaperId(newsPaperOptional.get().getNewsPaperId());

            newsPaper = newsPaperRepository.save(newsPaper);

            if (newsPaper != null) {
                responseModel.setMessage("News Paper Details Updated Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            }else{
                responseModel.setMessage("Failed To Update News Paper");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Update News Paper");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getNewsPaper(int newsPaperId) {
        ResponseModel responseModel = new ResponseModel();

        try {
            Optional<NewsPaper> newsPaperOptional = newsPaperRepository.findById(newsPaperId);

            if (!newsPaperOptional.isPresent()){
                responseModel.setMessage("There's No News Paper Exists ");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(newsPaperOptional.get(),HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Failed To Get The News Paper ");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> deleteNewsPaper(int newsPaperId) {
        ResponseModel responseModel = new ResponseModel();

        Optional<NewsPaper> newsPaperOptional = newsPaperRepository.findById(newsPaperId);

        try {
            if (!newsPaperOptional.isPresent()){
                responseModel.setMessage("There's No News Paper  Exists ");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            newsPaperRepository.deleteById(newsPaperOptional.get().getNewsPaperId());
            responseModel.setMessage("News Paper Removed Successfully");
            responseModel.setStatus(true);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);

        } catch (Exception e) {

            responseModel.setMessage("Failed To Remove News Paper ");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getAllNewsPapers() {

        ResponseModel responseModel = new ResponseModel();

        try {
            List<NewsPaper> newsPapers= new ArrayList<>();
            newsPapers=newsPaperRepository.findAll();

            if (newsPapers.isEmpty()){
                responseModel.setMessage("Nothing Found");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(newsPapers,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Nothing Found");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }
}

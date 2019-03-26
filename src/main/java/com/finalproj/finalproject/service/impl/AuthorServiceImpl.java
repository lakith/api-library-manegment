package com.finalproj.finalproject.service.impl;

import com.finalproj.finalproject.model.Author;
import com.finalproj.finalproject.model.ResponseModel;
import com.finalproj.finalproject.repository.AuthorRepository;
import com.finalproj.finalproject.service.AuthorService;
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
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public ResponseEntity<?> saveAuthor(Author author) {
        ResponseModel responseModel = new ResponseModel();
        author = authorRepository.save(author);

        try {
            if (author != null) {
                responseModel.setMessage("Author Saved Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
            }else{
                responseModel.setMessage("Failed To Save Author");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Save Author");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateAuthor(int authorId, Author author) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Author> optionalAuthor = authorRepository.findById(authorId);

            if (!optionalAuthor.isPresent()){
                responseModel.setMessage("There's No Author Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            author.setAuthorId(optionalAuthor.get().getAuthorId());

            author = authorRepository.save(author);

            if (author != null) {
                responseModel.setMessage("Author Details Updated Successfully");
                responseModel.setStatus(true);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            }else{
                responseModel.setMessage("Failed To Update Author");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseModel.setMessage("Failed To Update Author");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAuthor(int authorId) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Author> optionalAuthor = authorRepository.findById(authorId);

            if (!optionalAuthor.isPresent()){
                responseModel.setMessage("There's No Author Exists ");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(optionalAuthor.get(),HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Failed To Retrieve Author");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteAuthor(int authorId) {
        ResponseModel responseModel = new ResponseModel();

        try {

            Optional<Author> optionalAuthor = authorRepository.findById(authorId);

            if (!optionalAuthor.isPresent()){
                responseModel.setMessage("There's No  Author Exists");
                responseModel.setStatus(false);
                return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
            }

            authorRepository.deleteById(optionalAuthor.get().getAuthorId());
            responseModel.setMessage("Author Removed Successfully");
            responseModel.setStatus(true);
            return new ResponseEntity<>(responseModel,HttpStatus.OK);

        } catch (Exception e) {
            responseModel.setMessage("Failed To Delete Author");
            responseModel.setStatus(false);
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAllAuthors() {
        ResponseModel responseModel = new ResponseModel();

        try {
            List<Author> list= new ArrayList<>();
            list=authorRepository.findAll();

            if (list.isEmpty()){
                responseModel.setStatus(false);
                responseModel.setMessage("Nothing Found");
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

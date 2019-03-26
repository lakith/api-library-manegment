package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.model.NewsPaper;
import com.finalproj.finalproject.service.NewsPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/newsPapers")
public class NewsPaperController {


    @Autowired
    private NewsPaperService newsPaperService;

    @PostMapping()
    public ResponseEntity<?> saveNewsPaper(@Valid @RequestBody NewsPaper newsPaper) {
        return newsPaperService.saveNewsPaper(newsPaper);
    }

    @PutMapping("/{newsPaperId}")
    public ResponseEntity<?> updateNewsPaper(@Valid @PathVariable int newsPaperId, @RequestBody NewsPaper newsPaper) {
        return newsPaperService.updateNewsPaper(newsPaperId,newsPaper);
    }

    @DeleteMapping("/{newsPaperId}")
    public ResponseEntity<?> deleteNewsPaper(@PathVariable int newsPaperId) {
        return newsPaperService.deleteNewsPaper(newsPaperId);
    }

    @GetMapping("/{newsPaperId}")
    public ResponseEntity<?> getNewsPaper(@PathVariable int newsPaperId) {
        return newsPaperService.getNewsPaper(newsPaperId);
    }

    @GetMapping()
    public ResponseEntity<?> getAllNewsPapers() {
        return newsPaperService.getAllNewsPapers();
    }


    }

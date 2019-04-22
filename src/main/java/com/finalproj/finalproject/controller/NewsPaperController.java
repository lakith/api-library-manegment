package com.finalproj.finalproject.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finalproj.finalproject.model.NewsPaper;
import com.finalproj.finalproject.service.NewsPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/newsPapers")
@CrossOrigin
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

    @GetMapping("/filter-by-date")
    public ResponseEntity<?> getNewsPapersByDate(@RequestParam("start-date") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date startDate, @RequestParam("end-date") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date endDate){
        return newsPaperService.getNewsPapersByDate(startDate,endDate);
    }

    @GetMapping("/filter-by-name")
    public ResponseEntity<?> getNewsPapersByName(@RequestParam("name")String name){
        return newsPaperService.getNewsPapersByName(name);
    }

}

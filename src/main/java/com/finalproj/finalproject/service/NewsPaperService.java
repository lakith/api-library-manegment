package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.NewsPaper;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface NewsPaperService {

    ResponseEntity<?> saveNewsPaper(NewsPaper newsPaper);
    ResponseEntity<?> updateNewsPaper(int newsPaperId,NewsPaper newsPaper);
    ResponseEntity<?> getNewsPaper(int newsPaperId);
    ResponseEntity<?> deleteNewsPaper(int newsPaperId);
    ResponseEntity<?> getAllNewsPapers();
    ResponseEntity<?> getNewsPapersByDate(Date startDate, Date endDate);
    ResponseEntity<?> getNewsPapersByName(String name);

}

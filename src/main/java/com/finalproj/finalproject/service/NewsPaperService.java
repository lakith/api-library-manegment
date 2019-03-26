package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.NewsPaper;
import org.springframework.http.ResponseEntity;

public interface NewsPaperService {

    public ResponseEntity<?> saveNewsPaper(NewsPaper newsPaper);
    public ResponseEntity<?> updateNewsPaper(int newsPaperId,NewsPaper newsPaper);
    public ResponseEntity<?> getNewsPaper(int newsPaperId);
    public ResponseEntity<?> deleteNewsPaper(int newsPaperId);
    public ResponseEntity<?> getAllNewsPapers();

}

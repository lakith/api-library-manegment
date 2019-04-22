package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.Manuscript;
import org.springframework.http.ResponseEntity;

public interface ManuscriptService {

    ResponseEntity<?> saveManuscript(Manuscript manuscript);
    ResponseEntity<?> updateManuscript(int manuscriptId,Manuscript manuscript);
    ResponseEntity<?> getManuscript(int manuscriptId);
    ResponseEntity<?> deleteManuscript(int manuscriptId);
    ResponseEntity<?> getAllManuscripts();
    ResponseEntity<?> getManuscriptByYear(String year);
    ResponseEntity<?> getManuscriptByName(String name);

}

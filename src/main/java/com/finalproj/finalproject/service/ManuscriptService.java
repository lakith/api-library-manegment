package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.Manuscript;
import org.springframework.http.ResponseEntity;

public interface ManuscriptService {

    public ResponseEntity<?> saveManuscript(Manuscript manuscript);
    public ResponseEntity<?> updateManuscript(int manuscriptId,Manuscript manuscript);
    public ResponseEntity<?> getManuscript(int manuscriptId);
    public ResponseEntity<?> deleteManuscript(int manuscriptId);
    public ResponseEntity<?> getAllManuscripts();

}

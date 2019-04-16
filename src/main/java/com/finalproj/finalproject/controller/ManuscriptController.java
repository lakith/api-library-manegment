package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.model.Manuscript;
import com.finalproj.finalproject.service.ManuscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/manuscripts")
@CrossOrigin
public class ManuscriptController {

    @Autowired
    private ManuscriptService manuscriptService;

    @PostMapping()
    public ResponseEntity<?> saveManuscript(@Valid @RequestBody Manuscript manuscript) {
        return manuscriptService.saveManuscript(manuscript);
    }

    @PutMapping("/{manuscriptId}")
    public ResponseEntity<?> updateManuscript(@Valid @PathVariable int manuscriptId, @RequestBody Manuscript manuscript) {
        return manuscriptService.updateManuscript(manuscriptId,manuscript);
    }

    @DeleteMapping("/{manuscriptId}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int manuscriptId) {
        return manuscriptService.deleteManuscript(manuscriptId);
    }

    @GetMapping("/{manuscriptId}")
    public ResponseEntity<?> getAuthor(@PathVariable int manuscriptId) {
        return manuscriptService.getManuscript(manuscriptId);
    }

    @GetMapping()
    public ResponseEntity<?> getAuthors() {
        return manuscriptService.getAllManuscripts();
    }

}

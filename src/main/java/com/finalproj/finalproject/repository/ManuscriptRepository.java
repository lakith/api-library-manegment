package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Magazine;
import com.finalproj.finalproject.model.Manuscript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ManuscriptRepository extends JpaRepository<Manuscript,Integer> {

    @Query("SELECT mc FROM Manuscript mc WHERE mc.manuscriptName=?1")
    List<Manuscript> getManuscriptByName(String manuscriptName);

    @Query("SELECT mc FROM Manuscript mc WHERE mc.year=?1")
    List<Manuscript> getManuscriptYear(String year);


}

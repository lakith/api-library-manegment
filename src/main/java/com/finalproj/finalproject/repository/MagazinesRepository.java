package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface MagazinesRepository extends JpaRepository<Magazine,Integer> {

    @Query("SELECT mg FROM Magazine mg WHERE mg.date BETWEEN ?1 and  ?2")
    List<Magazine> getMagazinesByDate(Date date1,Date date2);

    @Query("SELECT mg FROM Magazine mg WHERE mg.magazineName=?1")
    List<Magazine> getMagazinesByName(String title);

    @Query("SELECT mg FROM Magazine mg WHERE mg.status=?1")
    List<Magazine> getMagazinesByStatus(String status);

}

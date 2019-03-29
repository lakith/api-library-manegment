package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazinesRepository extends JpaRepository<Magazine,Integer> {
}

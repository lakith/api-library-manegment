package com.finalproj.finalproject.repository;

import com.finalproj.finalproject.model.Magazine;
import com.finalproj.finalproject.model.NewsPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface NewsPaperRepository extends JpaRepository<NewsPaper,Integer> {

    @Query("SELECT np FROM NewsPaper np WHERE np.issueDate BETWEEN ?1 and  ?2")
    List<NewsPaper> getNewsPaperByDate(Date date1, Date date2);

    @Query("SELECT np FROM NewsPaper np WHERE np.newsPaperName=?1")
    List<NewsPaper> getNewsPaperByName(String title);

}

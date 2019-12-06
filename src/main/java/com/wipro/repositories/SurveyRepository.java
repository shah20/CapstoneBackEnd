package com.wipro.repositories;

import java.util.List;

import com.wipro.models.Survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SurveyRepository extends JpaRepository<Survey, Long>{ 

    @Query(value = "select * from survey where status='PUBLISHED'", nativeQuery = true)
    public List<Survey> findAllPublishedSurveys();

    @Query(value = "update Survey s set s.status='PUBLISHED' where s.id=?1")
    public Survey updateStatus(Long id);
}

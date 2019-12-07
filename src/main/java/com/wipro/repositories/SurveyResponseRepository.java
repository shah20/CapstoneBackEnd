package com.wipro.repositories;

import com.wipro.models.SurveyResponse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long>{ 

    public SurveyResponse findByEmailId(String emailId);
}

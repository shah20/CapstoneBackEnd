package com.wipro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.models.ResponseObject;
import com.wipro.models.SurveyResponse;
import com.wipro.repositories.SurveyResponseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService { 
    
	@Autowired
    SurveyResponseRepository surveyResponseRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

    public ResponseObject saveResponse(SurveyResponse surveyResponse) {
        
        LOGGER.info("Saving Response {}", surveyResponse);
        ResponseObject ro = new ResponseObject();
        this.surveyResponseRepository.save(surveyResponse);
        LOGGER.info("Response saved");
        return ro;
    }

    public ResponseObject checkuser(SurveyResponse surveyResponse) {
        
        LOGGER.info("Checking user {}", surveyResponse);
        ResponseObject responseObject;
        SurveyResponse response =  this.surveyResponseRepository.findByEmailIdAndSurveyId(surveyResponse.getEmailId(), surveyResponse.getsurveyId());
        if (response == null) {
            responseObject = new ResponseObject(true, "New user");
        } else {
            responseObject = new ResponseObject(false, "Already taken");
        }
        LOGGER.info("Result {}", responseObject);
        return responseObject;
    }

}

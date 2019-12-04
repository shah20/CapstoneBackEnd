package com.wipro.services;

import java.util.List;

import com.wipro.models.ResponseObject;
import com.wipro.models.Survey;
import com.wipro.models.User;
import com.wipro.repositories.SurveyRepository;
import com.wipro.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	@Autowired
    UserRepository userRepository;

	@Autowired
    SurveyRepository surveyRepository;

    public ResponseObject saveSurvey( Survey survey) {
        LOGGER.info("Saving Survey {}", survey);
        Survey savedData = this.surveyRepository.save(survey);
        LOGGER.info("Survey saved");
        return new ResponseObject(true, savedData);
    }

    public ResponseObject getAllDraftSurveys() {
        LOGGER.info("Fetching all draft surveys");
        List<Survey> allDraftSurveys = this.surveyRepository.findAllDraftSurveys();
        LOGGER.info("All Surveys {}", allDraftSurveys);
        return new ResponseObject(true, allDraftSurveys);
    }

    public ResponseObject login(String userName, String password) {
        LOGGER.info("Authenticating user {}", userName);
        ResponseObject response;
        User result = this.userRepository.findByEmailAndPassword(userName, password);
        if (result == null) {
            response = new ResponseObject(false, "Invalid credentials");
        } else {
            response = new ResponseObject(true, "Success");
        }
        LOGGER.info("Authentication result {}", response);
        return response;
    }

    public ResponseObject launchSurvey(Long surveyId) {

        LOGGER.info("Publishing survey {}", surveyId);
        Survey updatedSurvey = this.surveyRepository.findById(surveyId).orElse(null);
        updatedSurvey.setStatus("PUBLISHED");
        this.surveyRepository.save(updatedSurvey);
        LOGGER.info("Published survey {}", surveyId);
        return new ResponseObject(true, updatedSurvey);
    }
}
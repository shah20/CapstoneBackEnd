package com.wipro.controllers;

import java.util.List;
import java.util.Map;

import com.wipro.models.ResponseObject;
import com.wipro.models.Survey;
import com.wipro.models.User;
import com.wipro.repositories.SurveyRepository;
import com.wipro.repositories.UserRepository;
import com.wipro.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseObject login(@RequestBody Map<String, String> user) {
        
        return this.adminService.login(user.get("userName"), user.get("password"));
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public ResponseObject saveSurvey(@RequestBody Survey survey) {

        return this.adminService.saveSurvey(survey);
    }

    @RequestMapping(value = "/getAllDraftSurveys", method = RequestMethod.GET)
    public ResponseObject getAllDraftSurveys() {

        return this.adminService.getAllDraftSurveys();
    }

    @RequestMapping(value = "/launchSurvey", method = RequestMethod.PUT)
    public ResponseObject launchSurvey(@RequestBody Map<String, Long> surveyId) {

        return this.adminService.launchSurvey(surveyId.get("id"));
    }
}
package com.wipro.models;

import java.util.*;

import javax.persistence.*;

@Entity
public class SurveyResponse {

    @Id
    @GeneratedValue
    Long id;

    Long createdOn;
    String emailId;
    String name;
    Long survyeId;
    String surveyName;
    Long takenOn;
    Long validTill;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="response_question_answer_mapping",joinColumns=@JoinColumn(name="response_id"),inverseJoinColumns=@JoinColumn(name="question_id"))
    Collection<Question> questions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSurvyeId() {
        return survyeId;
    }

    public void setSurvyeId(Long survyeId) {
        this.survyeId = survyeId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public Long getTakenOn() {
        return takenOn;
    }

    public void setTakenOn(Long takenOn) {
        this.takenOn = takenOn;
    }

    public Long getValidTill() {
        return validTill;
    }

    public void setValidTill(Long validTill) {
        this.validTill = validTill;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "SurveyResponse [createdOn=" + createdOn + ", emailId=" + emailId + ", id=" + id + ", name=" + name
                + ", questions=" + questions + ", surveyName=" + surveyName + ", survyeId=" + survyeId + ", takenOn="
                + takenOn + ", validTill=" + validTill + "]";
    }

    public SurveyResponse() {
        super();
    }

    public SurveyResponse(Long createdOn, String emailId, String name, Long survyeId, String surveyName, Long takenOn,
            Long validTill, Collection<Question> questions) {
        super();
        this.createdOn = createdOn;
        this.emailId = emailId;
        this.name = name;
        this.survyeId = survyeId;
        this.surveyName = surveyName;
        this.takenOn = takenOn;
        this.validTill = validTill;
        this.questions = questions;
    }

}
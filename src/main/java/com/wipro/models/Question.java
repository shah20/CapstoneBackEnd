package com.wipro.models;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue
    Long Id;

    String question;
    String responseType;
    String validation;
    String options;

    // @ManyToOne
    // @JoinColumn(name="survey_id")
    // private Survey survey;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Question() {
        super();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question [Id=" + Id + ", options=" + options + ", question=" + question
                + ", responseType=" + responseType + ", validation=" + validation + "]";
    }
}

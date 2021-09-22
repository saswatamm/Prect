package com.example.prect;
public class Model {
    String Language;
    String Question;
    Model()
    {

    }



    Model(String Question, String Language)
    {
          this.Language = Language;
          this.Question = Question;
    }
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }





}

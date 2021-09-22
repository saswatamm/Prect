package com.example.prect;

public class Model1 {


    String Question;
    String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    String Language;

    Model1()
    {

    }


    Model1(String Question,String Language,String uid)
    {

        this.Question = Question;
        this.Language = Language;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

}

package com.example.administrator.travel_app.bean;

public class QuestionBean {
    String question;
    String answer;

    public QuestionBean(String s, String s1) {
        question = s;
        answer = s1;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

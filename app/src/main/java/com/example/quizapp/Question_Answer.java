package com.example.quizapp;

public class Question_Answer {
    private String Question;
    private String aA;
    private String aB;
    private String aC;
    private String aD;
    private String aTrue;

    public Question_Answer(String question, String aA, String aB, String aC, String aD, String aTrue) {
        Question = question;
        this.aA = aA;
        this.aB = aB;
        this.aC = aC;
        this.aD = aD;
        this.aTrue = aTrue;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getaA() {
        return aA;
    }

    public void setaA(String aA) {
        this.aA = aA;
    }

    public String getaB() {
        return aB;
    }

    public void setaB(String aB) {
        this.aB = aB;
    }

    public String getaC() {
        return aC;
    }

    public void setaC(String aC) {
        this.aC = aC;
    }

    public String getaD() {
        return aD;
    }

    public void setaD(String aD) {
        this.aD = aD;
    }

    public String getaTrue() {
        return aTrue;
    }

    public void setaTrue(String aTrue) {
        this.aTrue = aTrue;
    }
}

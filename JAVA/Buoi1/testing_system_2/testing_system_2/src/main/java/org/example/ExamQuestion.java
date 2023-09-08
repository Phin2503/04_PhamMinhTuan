package org.example;

public class ExamQuestion {
    public int examID;
    public int questionID = new Question().questionID;

    public ExamQuestion(int examID, int questionID) {
        this.examID = examID;
        this.questionID = questionID;
    }

}

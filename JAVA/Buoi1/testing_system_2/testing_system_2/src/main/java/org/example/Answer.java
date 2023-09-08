package org.example;

public class Answer {
    public int answerID;
    public String content;
    public int questionID = new Question().questionID;
    public Boolean isCorrect;


    public Answer() {

    }

    public Answer(int answerID, String content, int questionID, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.questionID = questionID;
        this.isCorrect = isCorrect;

    }
}

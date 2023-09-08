package org.example;

import java.util.Date;

public class Exam {
    public int examID;
    public String code;
    public int categoryID = new CategoryQuestion().categoryID;
    public String duration;
    public int createID = new Account().accountID;
    public Date createDate;


    public Exam(int examID, String code, int categoryID, String duration, int creatorID, Date createDate) {
        this.examID = examID;
        this.code = code;
        this.categoryID = categoryID;
        this.duration = duration;
        this.createID = creatorID;
        this.createDate = createDate;
    }
}

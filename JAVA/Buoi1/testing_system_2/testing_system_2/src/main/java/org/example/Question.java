package org.example;

import java.util.Date;

public class Question {
    public int questionID;
    public String content;
    public int categoryID = new CategoryQuestion().categoryID;
    public int typeID = new TypeQuestion().typeID;
    public int createID = new Account().accountID;
    public Date createDate;

    public Question(){

    }

    public Question(int questionID, String content, int categoryID, int typeID, int createID, Date createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categoryID = categoryID;
        this.typeID = typeID;
        this.createID = createID;
        this.createDate = createDate;
    }
}

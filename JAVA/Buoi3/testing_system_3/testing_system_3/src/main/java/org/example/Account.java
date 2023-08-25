package org.example;

import java.util.Date;

public class Account {
    int accountID;
    String email;
    String userName;
    String fullName;
    String positionName;
    int departmentID;
    int positionID;
    Date createDate;
    int numOfGroup;
    float wage;

    public Account(){

    }

    public Account(int accountID, String userName, float wage) {
        this.accountID = accountID;
        this.userName = userName;
        this.wage = wage;
    }
}

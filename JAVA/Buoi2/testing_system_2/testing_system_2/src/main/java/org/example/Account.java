package org.example;

import java.util.Date;

public class Account {
    public int accountID;
    public String email;
    public String userName;
    public String fullName;
    public int departmentID = new Department().departmentID;
    public int positionID = new Position().positionID;
    public Date createDate;

    public int numOfGroup ;
    public String positionName;
    public Account(){

    }

    public Account(int accountID, String email, String username, String fullName, int departmentID, int position, Date createDate, int numOfGroup) {
        this.accountID = accountID;
        this.email = email;
        this.userName = username;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.positionID = position;
        this.createDate = createDate;
        this.numOfGroup = numOfGroup;
    }

    public Account(int accountID, String email, String username, String fullName, int positionID, Date createDate) {
        this.accountID = accountID;
        this.email = email;
        this.userName = username;
        this.positionID = positionID;
        this.createDate = createDate;

    }


    public Account(int accountID, String email, String username, String fullName, int departmentID, int position, Date createDate,String positionName) {
        this.accountID = accountID;
        this.email = email;
        this.userName = username;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.positionID = position;
        this.createDate = createDate;
        this.positionName = positionName;
    }
}

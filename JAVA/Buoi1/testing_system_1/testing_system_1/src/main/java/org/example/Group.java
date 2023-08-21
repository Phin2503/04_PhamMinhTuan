package org.example;

import java.util.Date;

public class Group {
    public int groupID;
    public String groupName;
    public int  createID = new Account().accountID;
    public Date joinDate;

    public Group(){

    }

    public Group(int groupID, String groupName, int creatorID, Date joinDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.createID = creatorID;
        this.joinDate = joinDate;
    }
}

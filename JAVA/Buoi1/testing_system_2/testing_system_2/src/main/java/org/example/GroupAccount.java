package org.example;

import java.util.Date;

public class GroupAccount {


        public int groupID;
        public int accountID;
        public Date joinDate;

        public int numberOfGroup;
        // Constructor mặc định
        public GroupAccount() {
        }

        // Constructor có tham số
        public GroupAccount(int groupID, int accountID, Date joinDate,int numberOfGroup) {

            this.groupID = groupID;
            this.accountID = accountID;
            this.joinDate = joinDate;
            this.numberOfGroup = numberOfGroup;
        }

        // Các getter và setter

}

package org.example;

import java.util.Date;

public class GroupAccount {


        private int groupID;
        private int accountID;
        private Date joinDate;

        // Constructor mặc định
        public GroupAccount() {
        }

        // Constructor có tham số
        public GroupAccount(int groupID, int accountID, Date joinDate) {
            this.groupID = groupID;
            this.accountID = accountID;
            this.joinDate = joinDate;
        }

        // Các getter và setter

}

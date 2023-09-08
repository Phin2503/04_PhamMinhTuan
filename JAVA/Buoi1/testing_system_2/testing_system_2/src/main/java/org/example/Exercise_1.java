package org.example;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;
public class Exercise_1 {
//    public static void main(String[] args) {
//        Department department1 = new Department(1,"Sale");
//        Department department2 = new Department(2,"Marketing");
//        Department department3 = new Department(3,"Development");
//
//
//        // Khởi tạo đối tượng Position
//        Position position1 = new Position(1, "Developer");
//        Position position2 = new Position(2, "Tester");
//        Position position3 = new Position(3, "Project Manager");
//
//        // Khởi tạo đối tượng Account
//        Date createDate = new Date();
//        Account account1 = new Account(1,"john@example.com", "john", "John Doe", position1.positionID, createDate);
//        Account account2 = new Account(2,"anna@example.com", "anna", "Anna Smith", department1.departmentID, position2.positionID, createDate);
//        Account account3 = new Account(3,"robert@example.com", "robert", "Robert Williams", department2.departmentID, position3.positionID, createDate);
//
//        question_1(account2);
//    }

    public static void question_1 (Account account) {
        if(account.departmentID == 0){
            System.out.println("Nhan vien nay chua co phong ban");
        }else {
            System.out.println("Phong ban cua nhan vien nay la : " + account.departmentID);
        }
    }


    public static void question_2 (GroupAccount GroupAccount , GroupAccount GroupAccount2 , GroupAccount GroupAccount3 , GroupAccount GroupAccount4 ) {
        if ( GroupAccount.accountID == 2 && GroupAccount2.accountID == 2 && GroupAccount3.accountID == 2 && GroupAccount4.accountID == 2){
            System.out.println("Nhân viên này là người hóng chuyện , tham gia tất cả group");
        }else if (GroupAccount.accountID == 2 && GroupAccount2.accountID == 2 && GroupAccount3.accountID == 2){
            System.out.println("Nhân viên này là người quan trọng và tham gia nhiều Group");
        } else if(GroupAccount.groupID == 2 || GroupAccount2.groupID == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# fresher");
        }else{
            System.out.println("Nhân viên này chưa có group");
        }
    }

    public static void question_3(Account account) {
        String result = account.departmentID == 0 ? "Nhan vien nay chua co phong ban" : "Nhan vien nay có phòng ban là : " + account.departmentID; ;
        System.out.println(result);
    }

    public static void question_4(Account account) {
       String result =  (account.positionName == "Dev") ? "Day la Developer" : "Nguoi nay khong phai Developer";
        System.out.println(result);
    }

    public static void question_5(GroupAccount groupAccount) {


        if (groupAccount.numberOfGroup == 1) {
            System.out.println("Nhóm có một thành viên");
        } else if (groupAccount.numberOfGroup == 2) {
            System.out.println("Nhóm có hai thành viên");
        } else if (groupAccount.numberOfGroup == 3) {
            System.out.println("Nhóm có ba thành viên");
        } else {
            System.out.println("Nhóm có nhiều thành viên");
        }
    }


    public static void question_6(Account account){
        switch (account.numOfGroup) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public static void question_7(Account account){
        String positionOfAccount1 = "Dev";
        int positionCode;

        switch (positionOfAccount1) {
            case "Dev":
                positionCode = 1;
                break;
            default:
                positionCode = 0;
        }

        switch (positionCode) {
            case 1:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }
    }

    public static void question_8(Account account) {
        System.out.println("Email: " + account.email);
        System.out.println("FullName: " + account.fullName);
        System.out.println("DepartmentName: " + account.departmentID);
        System.out.println(); // Dòng trắng để phân tách giữa các tài khoản
    }

    public static void question_9(List<Department> departments) {

        for (Department department : departments) {
            System.out.println("ID: " + department.departmentID);
            System.out.println("Name: " + department.departmentName);
            System.out.println(); // Dòng trắng để phân tách giữa các phòng ban
        }
    }

    public static void question_10 (){
        Account[] accounts = new Account[2];

        // Điều này chỉ là ví dụ, bạn cần thay đổi các giá trị dựa trên dữ liệu thực tế
        accounts[0] = new Account("NguyenVanA@gmail.com", "Nguyễn Văn A", "Sale");
        accounts[1] = new Account("NguyenVanB@gmail.com", "Nguyễn Văn B", "Marketting");

        // In ra thông tin của các tài khoản
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email;
            System.out.println("Full name: " + accounts[i].fullName;
            System.out.println("Phòng ban: " + accounts[i].departmentID;
            System.out.println();
        }
    }

    public static void question_11(){
        List<Department> departments = new ArrayList<>();

        // Điều này chỉ là ví dụ, bạn cần thay đổi các giá trị dựa trên dữ liệu thực tế
        departments.add(new Department(1, "Sale"));
        departments.add(new Department(2, "Marketing"));

        // In ra thông tin của các phòng ban
        for (int i = 0; i < departments.size(); i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments.get(i).departmentID);
            System.out.println("Name: " + departments.get(i).departmentName);
            System.out.println();
        }
    }
}

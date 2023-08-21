package org.example;

import java.util.Date;

public class Main {



    public static void main(String[] args) {
        Department department1 = new Department(1,"Sale");
        Department department2 = new Department(2,"Marketing");
        Department department3 = new Department(3,"Development");


        // Khởi tạo đối tượng Position
        Position position1 = new Position(1, "Developer");
        Position position2 = new Position(2, "Tester");
        Position position3 = new Position(3, "Project Manager");

        // Khởi tạo đối tượng Account
        Date createDate = new Date();
        Account account1 = new Account(1,"john@example.com", "john", "John Doe", department3.departmentID, position1.positionID, createDate);
        Account account2 = new Account(2,"anna@example.com", "anna", "Anna Smith", department1.departmentID, position2.positionID, createDate);
        Account account3 = new Account(3,"robert@example.com", "robert", "Robert Williams", department2.departmentID, position3.positionID, createDate);

        // Khởi tạo đối tượng Group
        Group group1 = new Group(1,"Developers", account1.accountID, createDate);
        Group group2 = new Group(2,"Testers", account2.accountID, createDate);
        Group group3 = new Group(3,"Managers", account3.accountID, createDate);

        // Khởi tạo đối tượng GroupAccount
        GroupAccount groupAccount1 = new GroupAccount(group1.groupID, account1.accountID, createDate);
        GroupAccount groupAccount2 = new GroupAccount(group2.groupID, account2.accountID, createDate);
        GroupAccount groupAccount3 = new GroupAccount(group3.groupID, account3.accountID, createDate);

        // Khởi tạo đối tượng TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion(1,"Essay");
        TypeQuestion typeQuestion2 = new TypeQuestion(2,"Multiple-Choice");

        // Khởi tạo đối tượng CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion(1,"Java");
        CategoryQuestion categoryQuestion2 = new CategoryQuestion(2,".NET");
        CategoryQuestion categoryQuestion3 = new CategoryQuestion(3,"SQL");

        // Khởi tạo đối tượng Question
        Question question1 = new Question(1,"What is Java?", categoryQuestion1.categoryID, typeQuestion1.typeID, account1.accountID, createDate);
        Question question2 = new Question(2,"What is .NET?", categoryQuestion2.categoryID, typeQuestion2.typeID, account2.accountID, createDate);
        Question question3 = new Question(3,"What is SQL?", categoryQuestion3.categoryID, typeQuestion1.typeID, account3.accountID, createDate);

        // Khởi tạo đối tượng Answer
        Answer answer1 = new Answer(1,"Java is a programming language", question1.questionID, true);
        Answer answer2 = new Answer(2,".NET is a framework", question2.questionID, false);
        Answer answer3 = new Answer(3,"SQL is a query language", question3.questionID, true);

        // Khởi tạo đối tượng Exam
        Exam exam1 = new Exam(1,"Java Basics", categoryQuestion1.categoryID,"2020-01-21", account1.accountID, createDate);
        Exam exam2 = new Exam(2,".NET Fundamentals", categoryQuestion2.categoryID, "2021-03-12", account2.accountID, createDate);
        Exam exam3 = new Exam(3,"SQL Essentials", categoryQuestion3.categoryID,"2022-08-17" ,account3.accountID, createDate);

        // Khởi tạo đối tượng ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion(exam1.examID, question1.questionID);
        ExamQuestion examQuestion2 = new ExamQuestion(exam2.examID, question2.questionID);
        ExamQuestion examQuestion3 = new ExamQuestion(exam3.examID, question3.questionID);

        // In thông tin đối tượng đã khởi tạo
        System.out.println(department1.departmentName);
        System.out.println(position2.positionName);
        System.out.println(account3.accountID);
        System.out.println(group1.groupName);
        System.out.println(groupAccount3);
        System.out.println(typeQuestion1.typeName);
        System.out.println(categoryQuestion3.categoryName);
        System.out.println(question1);
        System.out.println(answer3.content);
        System.out.println(exam2);
        System.out.println(examQuestion3);
        System.out.println(department1.departmentName);
    }
}
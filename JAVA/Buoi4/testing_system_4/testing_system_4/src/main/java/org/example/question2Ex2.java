package org.example;


import java.util.Scanner;

class Person {
    private String name;
    private String gender;
    private String birthDate;
    private String address;

    public Person() {
    }

    public Person(String name, String gender, String birthDate, String address) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter gender: ");
        gender = scanner.nextLine();
        System.out.print("Enter birth date: ");
        birthDate = scanner.nextLine();
        System.out.print("Enter address: ");
        address = scanner.nextLine();
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Address: " + address);
    }
}

class Students extends Person {
    private String studentId;
    private double averageScore;
    private String email;

    public Students() {
    }

    public Students(String name, String gender, String birthDate, String address, String studentId, double averageScore, String email) {
        super(name, gender, birthDate, address);
        this.studentId = studentId;
        this.averageScore = averageScore;
        this.email = email;
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        studentId = scanner.nextLine();
        System.out.print("Enter average score: ");
        averageScore = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter email: ");
        email = scanner.nextLine();
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Email: " + email);
    }

    public boolean hasScholarship() {
        return averageScore >= 8.0;
    }
}

public class question2Ex2 {
    public static void main(String[] args) {
        Students student = new Students();
        student.inputInfo();
        System.out.println("\nStudent Info:");
        student.showInfo();

        if (student.hasScholarship()) {
            System.out.println("This student has a scholarship.");
        } else {
            System.out.println("This student does not have a scholarship.");
        }
    }
}
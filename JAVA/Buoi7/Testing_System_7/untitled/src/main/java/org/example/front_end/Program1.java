package org.example.front_end;

import org.example.backend.Ex1;

import java.util.ArrayList;

public class Program1 extends Ex1 {
    public static void main(String[] args) {

        // Question 1
        ArrayList<Student> listStudents = new ArrayList<Student>();

        Student student1 = new Student(1,"Phạm Minh Tuấn");
        Student student2 = new Student(2, "Phạm Quang Dũng");
        Student student3 = new Student(3,"Bùi Huy Hoàng");

        listStudents.add(student1);
        listStudents.add(student2);
        listStudents.add(student3);

        for (Student st : listStudents) {
            System.out.println(st.getCollege());
        }

        for (Student st : listStudents) {

            st.setCollege("Đại học Công nghệ");
            System.out.println(st.getCollege());
        }

        //Question 2

        Student.step1(listStudents,100);
        Student.step2();
        Student.step3();
        Student.step4();
        Student.step5(listStudents,50);

        // Question3
        System.out.println(MyMath.max(1, 1.0));
        System.out.println(MyMath.sum(1,2));
        System.out.println(MyMath.min(1,3));

        //Question 4
        System.out.println(Student.getCollege());

        //Question 5
        Student student4 = new Student(4,"Phạm Quang Huy");
        System.out.println(Student.getInstanceCount());

        // Question 6

        SecondaryStudent scStudent1 = new SecondaryStudent();
        SecondaryStudent scStudent2 = new SecondaryStudent();
        SecondaryStudent scStudent3 = new SecondaryStudent();
        SecondaryStudent scStudent4 = new SecondaryStudent();

        try {
            PrimaryStudent prStudent1 = new PrimaryStudent();
            PrimaryStudent prStudent2 = new PrimaryStudent();
            PrimaryStudent prStudent3 = new PrimaryStudent();
            PrimaryStudent prStudent4 = new PrimaryStudent();
            PrimaryStudent prStudent5 = new PrimaryStudent();
            PrimaryStudent prStudent6 = new PrimaryStudent();
            PrimaryStudent prStudent7 = new PrimaryStudent();
            PrimaryStudent prStudent8 = new PrimaryStudent();
        }catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(SecondaryStudent.getCountInstance());
        System.out.println(PrimaryStudent.getCountInstance());
    }
}

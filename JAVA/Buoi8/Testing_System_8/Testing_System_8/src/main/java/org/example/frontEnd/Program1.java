package org.example.frontEnd;

import org.example.backend.Exercise1;

import java.util.*;

public class Program1 extends Exercise1 {


    public static void main(String[] args) {
        // Question 1
        ArrayList<student> listStudent = new ArrayList<student>();
        listStudent.add(new student(1,"Tuan"));
        listStudent.add(new student(2,"Quang"));
        listStudent.add(new student(4,"Hung"));
        listStudent.add(new student("Tuan"));
        listStudent.add(new student("Tuan"));
        listStudent.add(new student(5,"Quang"));
        int totalELement = listStudent.size();
        System.out.println(totalELement);
        System.out.println(listStudent.get(4).getName());
        System.out.println(listStudent.get(4).getId());
        System.out.println(listStudent.get(0).getName());
        System.out.println(listStudent.get(totalELement - 1).getName());
        listStudent.add(0,new student(0, "Ha"));
        System.out.println(listStudent.get(0).getName());
        listStudent.add(new student(8,"Minh"));


        for(int i = 0 ; i <= listStudent.size() - 1; i++) {
            student reverse =  listStudent.get(listStudent.size() - 1);
            listStudent.remove(listStudent.size() - 1);
            listStudent.add(i,reverse);
            System.out.println(listStudent);
        }

        for (student listReverse : listStudent) {
            System.out.println(listReverse.getName());
        }

        System.out.println(student.findStudent(listStudent,10));
        System.out.println(student.findStudenWithName(listStudent,"Tuan"));


        for(student listFind : listStudent) {
            if(listFind.getId() == 2){
                listFind.setName(null);
            }
        }

        Iterator<student> iterator = listStudent.iterator();

        while (iterator.hasNext()) {
            student element = iterator.next();
            if (element.getId() == 5) {
                iterator.remove(); // Xoá phần tử "B"
            }
        }

        for(student find : listStudent){
            System.out.println(find.getId());
        }
        System.out.println(student.findStudent(listStudent,5));

        ArrayList<student> studentCopies = new ArrayList<>();
        studentCopies.addAll(listStudent);

        // Question 2

        Stack<student> studentsJoin = new Stack<>();
        studentsJoin.add(new student("Nguyen Van Nam"));
        studentsJoin.add(new student("Nguyen Van Huyen"));
        studentsJoin.add(new student("Tran Van Nam"));
        studentsJoin.add(new student("Nguyen Van A"));


        System.out.println(student.joinLateToSoon(studentsJoin));

        Queue<student> studentsJoin2 = new LinkedList<>();
        studentsJoin2.offer(new student("Nguyen Van Nam"));
        studentsJoin2.offer(new student("Nguyen Van Huyen"));
        studentsJoin2.offer(new student("Tran Van Nam"));
        studentsJoin2.offer(new student("Nguyen Van A"));

        System.out.println(student.joinSoonToLate(studentsJoin2));

        // Question 3
         Set<student> newSet = new HashSet<>();
         newSet.add(new student("Pham Minh Tuan"));
        // Question 4

        Set<String> studentss = new HashSet<>();
        studentss.add("Minh");
        studentss.add("Hung");
        studentss.add("Quang");
        studentss.add("Minh");
        System.out.println(studentss);

        // Question 5
        Set<String> student3 = new TreeSet<>();
        student3.add("A");
        student3.add("A");
        student3.add("Z");
        student3.add("B");
        student3.add("C");
        System.out.println(student3);

        // Question 6,7
        Map<Integer , String> student4 = new HashMap<>();
        student4.put(1,"Pham Minh Tuan");
        student4.put(2,"Minh");
        student4.put(3,"An");

        System.out.println(student4 .keySet());
        System.out.println(student4.values());
        Map<String,student> student5 = new TreeMap<>();
        student5.put("Tuan",new student(1,"Tuan"));
        student5.put("Quang",new student(2,"Quang"));
        student5.put("An",new student(3,"An"));

        for (Map.Entry<String, student> entry : student5.entrySet()) {
            String name = entry.getKey();
            student student = entry.getValue();
            System.out.println("Tên: " + name );
        }
        // Question 7d
        Set<student> studentSet = new HashSet<>(student5.values());
    }
}

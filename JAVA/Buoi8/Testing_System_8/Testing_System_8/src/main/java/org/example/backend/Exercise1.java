package org.example.backend;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Exercise1 {
    public static class student {

        protected String name;
        protected static int nextId = 1;
        protected int id;

        public void setName(String name) {
            this.name = name;
        }

        public student (int id, String name){
            this.id = id;
            this.name = name;
        }

        public student(String name) {
            this.id = nextId++;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static String findStudent(ArrayList<student> listStudent, int id) {
            String result = "Khong tim thay hoc sinh co id = : " + id;
            for(student listFind : listStudent){
                System.out.println(listFind.getId());
                if(listFind.getId() == id){
                    result = listFind.getName();
                }
            }
            return result;
        }

        public static String findStudenWithName(ArrayList<student> listStudent, String name) {
            String result = "Khong tim thay hoc sinh co ten la : " + name;
            for(student listFind : listStudent){
                if(listFind.getName() == name){
                    result = (listFind.getId() + "");
                }
            }
            return result;
        }

        public static String joinLateToSoon(Stack<student> joinStudents){
            String result = "";
            int dem = joinStudents.size();
            for (int i = 1; i <= dem; i++){
                result += joinStudents.pop().getName() + ",";
            }
            result = result.substring(0,result.length()-1);
            return result;
        }

        public static String joinSoonToLate(Queue<student> joinStudents){
            String result = "";
            int dem = joinStudents.size();
            for (int i = 1; i <= dem; i++){
                result += joinStudents.poll().getName() + ",";
            }
            result = result.substring(0,result.length()-1);
            return result;
        }


    }
}

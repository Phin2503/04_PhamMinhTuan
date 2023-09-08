package org.example.backend;

import java.util.ArrayList;

public class Ex1 {

    public static abstract class HinhHoc{
        HinhHoc(){

        }
    }

    public static class HinhTron extends HinhHoc{
        private static int countInstance;
        private static int configs = 5;

        public HinhTron() throws IllegalAccessException {

            if(countInstance >= 7) {
                throw new IllegalAccessException("Số lượng hình tối đa là : " + configs);
            }
            countInstance++;
        }

        public static int getCountInstance(){
            return countInstance;
        }
    }

    public static class HinhChuNhat extends HinhHoc{
        private static int countInstance;
        private static int configs = 5;

        public HinhChuNhat() throws IllegalAccessException {

            if(countInstance >= 7) {
                throw new IllegalAccessException("Số lượng hình tối đa là : " + configs);
            }
            countInstance++;
        }

        public static int getCountInstance(){
            return countInstance;
        }
    }

    public static class PrimaryStudent{
        private static int countInstance;

        public PrimaryStudent() throws IllegalAccessException {

            if(countInstance >= 7) {
                throw new IllegalAccessException("Đã quá số lượng tạo");
            }
            countInstance++;
        }


        public static int getCountInstance(){
            return countInstance;
        }
    }

    public static class SecondaryStudent{
        private static int countInstance;

        public SecondaryStudent(){
            countInstance++;
        }

        public static int getCountInstance(){
            return countInstance;
        }
    }

    public static class MyMath {

        public static int max(int a, int b){
            if(a < b) {
                return b;
            }else {
                return a;
            }
        }

        public static float max(float a, float b){
            if(a < b) {
                return b;
            }else {
                return a;
            }
        }

        public static double max(double a, double b){
            if(a < b) {
                return b;
            }else {
                return a;
            }
        }


        public static int sum(int a, int b){
            return a + b;
        }

        public static double sum(double a, double b){
            return a + b;
        }

        public static long sum(long a, long b){
            return a + b;
        }

        public static int min(int a, int b){
            if(a < b) {
                return a;
            }else {
                return b;
            }
        }

        public static float min(float a, float b){
            if(a < b) {
                return a;
            }else {
                return b;
            }
        }

        public static double min(double a, double b){
            if(a < b) {
                return a;
            }else {
                return b;
            }
        }

    }

    public static class Student {
        private int id;
        private String name;
        private static String college;
        private static int moneyGroup;

        private static int countInstance;
        //constructor
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
            college = "Đại học Back Khoa";
            countInstance++;
        }

        public Student (){
            countInstance++;
        }

        public static int getInstanceCount() {
            // Trả về số lượng thể hiện đã được tạo
            return countInstance;
        }

        //getter
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static String getCollege() {
            return college;
        }

        //setter
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static void setCollege(String college){
            Student.college = college;
        }

        public static void step1(ArrayList<Student> list,int moneys){
            for( Student list2 : list ){
                moneyGroup += moneys;
            }
            System.out.println("Số tiền khi các học sinh nộp ban đầu là  : " + moneyGroup);
        }

        public static void step2(){
            moneyGroup = moneyGroup - 50;
            System.out.println("Student thứ 1 lấy 50k đi mua bim bim , kẹo về liên hoan và số tiền quỹ còn là : " + moneyGroup);
        }

        public static void step3(){
            moneyGroup = moneyGroup - 20;
            System.out.println("Student thứ 2 lấy 20k đi mua bánh mì và số tiền quỹ còn là : " + moneyGroup);
        }

        public static void step4(){
            moneyGroup = moneyGroup - 150;
            System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm và số tiền quỹ còn là : " + moneyGroup);
        }

        public static void step5(ArrayList<Student> list, int moneys){
            for( Student list2 : list ){
                moneyGroup += moneys;
            }
            System.out.println("Số tiền khi các học sinh đóng lại quỹ mỗi người 50K  : " + moneyGroup);
        }




    }

    public static void main(String[] args) {

    }

}

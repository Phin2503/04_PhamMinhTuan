package org.example.backend;

public class Ex2 {
    public static class MyMath {
        private final float  PI = 3.14F;

        public float sum (int a){
            return (float)(a + PI);
        }
    }

    public static class Student {
        private final int id = 1;
        private String name ;

        public Student() {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public final void study(){
            System.out.println("Đang học bài ...");
        }
    }

    public static final class PrimaryStudent extends Student{

        public PrimaryStudent(String name) {
            super();
        }

        public PrimaryStudent() {
            super();
        }
    }

    public static final class SecondaryStudent extends Student{

        public SecondaryStudent(String name) {
            super();
        }
    }

}

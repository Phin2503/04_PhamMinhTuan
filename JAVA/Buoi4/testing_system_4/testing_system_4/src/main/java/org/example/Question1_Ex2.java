package org.example;

interface IStudent {
    void diemDanh();
    void hocBai();
    void diDonVeSinh();
}

class Student implements IStudent {
    private int id;
    private String name;
    protected int group;

    public Student(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    @Override
    public void diemDanh() {
        System.out.println(name + " điểm danh");
    }

    @Override
    public void hocBai() {
        System.out.println(name + " đang học bài");
    }

    @Override
    public void diDonVeSinh() {
        System.out.println(name + " đi dọn vệ sinh");
    }
}

public class Question1_Ex2{
    public static void main(String[] args) {
        Student[] students = new Student[10];

        for (int i = 0; i < 10; i++) {
            int group = i % 3 + 1; // Chia thành 3 nhóm
            students[i] = new Student(i + 1, "Nguyễn Văn " + (char)('A' + i), group);
        }

        // Kêu gọi cả lớp điểm danh
        for (Student student : students) {
            student.diemDanh();
        }

        // Gọi nhóm 1 đi học bài
        System.out.println("\nNhóm 1 đi học bài:");
        for (Student student : students) {
            if (student.group == 1) {
                student.hocBai();
            }
        }

        // Gọi nhóm 2 đi dọn vệ sinh
        System.out.println("\nNhóm 2 đi dọn vệ sinh:");
        for (Student student : students) {
            if (student.group == 2) {
                student.diDonVeSinh();
            }
        }
    }
}

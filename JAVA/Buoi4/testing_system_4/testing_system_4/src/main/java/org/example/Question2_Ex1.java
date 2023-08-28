package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ThiSinh {
    private String soBaoDanh;
    private String hoTen;
    private String diaChi;
    private int mucUuTien;

    public ThiSinh(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        this.soBaoDanh = soBaoDanh;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getMucUuTien() {
        return mucUuTien;
    }
}

interface ITuyenSinh {
    void themMoiThiSinh();
    void hienThiThongTin();
    void timKiemTheoSoBaoDanh();
    void thoat();
}

class TuyenSinh implements ITuyenSinh {
    private List<ThiSinh> danhSachThiSinh = new ArrayList<>();

    @Override
    public void themMoiThiSinh() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số báo danh: ");
        String soBaoDanh = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập mức ưu tiên: ");
        int mucUuTien = scanner.nextInt();
        scanner.nextLine(); // Đọc newline character

        ThiSinh thiSinh = new ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien);
        danhSachThiSinh.add(thiSinh);
    }

    @Override
    public void hienThiThongTin() {
        for (ThiSinh thiSinh : danhSachThiSinh) {
            System.out.println("Số báo danh: " + thiSinh.getSoBaoDanh());
            System.out.println("Họ tên: " + thiSinh.getHoTen());
            System.out.println("Địa chỉ: " + thiSinh.getDiaChi());
            System.out.println("Mức ưu tiên: " + thiSinh.getMucUuTien());
            System.out.println();
        }
    }

    @Override
    public void timKiemTheoSoBaoDanh() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số báo danh cần tìm kiếm: ");
        String soBaoDanh = scanner.nextLine();

        for (ThiSinh thiSinh : danhSachThiSinh) {
            if (thiSinh.getSoBaoDanh().equals(soBaoDanh)) {
                System.out.println("Thông tin thí sinh có số báo danh " + soBaoDanh + ":");
                System.out.println("Họ tên: " + thiSinh.getHoTen());
                System.out.println("Địa chỉ: " + thiSinh.getDiaChi());
                System.out.println("Mức ưu tiên: " + thiSinh.getMucUuTien());
                return;
            }
        }

        System.out.println("Không tìm thấy thí sinh có số báo danh " + soBaoDanh);
    }

    @Override
    public void thoat() {
        System.out.println("Thoát khỏi chương trình.");
        System.exit(0);
    }
}

class Question2_Ex2 {
    public static void main(String[] args) {
        ITuyenSinh tuyenSinh = new TuyenSinh();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Thêm mới thí sinh");
            System.out.println("2. Hiển thị thông tin thí sinh");
            System.out.println("3. Tìm kiếm theo số báo danh");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc newline character

            switch (choice) {
                case 1:
                    tuyenSinh.themMoiThiSinh();
                    break;
                case 2:
                    tuyenSinh.hienThiThongTin();
                    break;
                case 3:
                    tuyenSinh.timKiemTheoSoBaoDanh();
                    break;
                case 4:
                    tuyenSinh.thoat();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 4);

        scanner.close();
    }
}

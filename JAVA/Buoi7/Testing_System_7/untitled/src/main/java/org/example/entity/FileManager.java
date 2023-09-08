package org.example.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static boolean isFileExists (String path){
        File f = new File(path);
        if(f.exists()){
            return true;
        }else{
            return false;
        }
    }

    public static void createNewFile(String pathFile, String fileName){
        String newPath = pathFile + "/" + fileName;
        File fCheck = new File(newPath);
        try {
            if(fCheck.createNewFile()){
                System.out.println("tao tep thanh cong");
            }else{
                System.out.println("Tep da ton tai");
            }
        }catch (IOException e){
            System.out.println("Loi khi tao tep moi :" + e.getMessage());
        }
    }

    public static void deleteFile(String path, String nameFile) throws FileNotFoundException {
        String newPath = path + "/" + nameFile;
        File f = new File(newPath);

        if(!f.exists()){
            throw new FileNotFoundException("Error ! FIle Not Exists ");
        }

        if(f.delete()){
            System.out.println("Xoá Thành Công ");
        }else{
            System.out.println("Xoá không thành công");
        }
    }

    public static void isFolder(String path) {
        File file = new File(path);
        // Sử dụng isDirectory() để kiểm tra xem đường dẫn là một thư mục
        if(file.isDirectory()){
            System.out.println("Đây là thư mục");
        }else{
            System.out.println("Đây là tệp");
        }
    }

    public static List<String> getAllFileName(String path) {
        File folder = new File(path);
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Error! Path is not folder.");
        }

        List<String> fileNames = new ArrayList<>();

        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }

        return fileNames;
    }

    public static void createNewFolder(String newPathFolder) {
        File newFolder = new File(newPathFolder);

        if (newFolder.exists()) {
            throw new IllegalArgumentException("Error! Folder Exist.");
        }

        if (newFolder.mkdirs()) {
            System.out.println("Tạo thư mục mới thành công");
        } else {
            System.out.println("Không thể tạo thư mục mới");
        }
    }

    public static void moveFile(String pathFile, String pathFIle2){
        File f = new File(pathFile);
        File f2 = new File(pathFIle2);

        if(!f.exists()){
            throw new IllegalArgumentException("Khong ton tai");
        }

        if(!f2.exists()){
            f2.mkdirs();
        }

        File newPath = new File(pathFIle2, f.getName());

        if(newPath.exists()){
            throw new IllegalArgumentException("Tep nay da ton tai trong thu muc ban muon chuyen den");
        }

        if(f.renameTo(newPath)){
            System.out.println("chuyen thanh cong");
        }else{
            System.out.println("Chuyen khong thanh cong");
        }
    }



}

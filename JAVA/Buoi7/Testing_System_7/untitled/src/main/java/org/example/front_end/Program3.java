package org.example.front_end;

import org.example.entity.FileManager;

import java.io.File;
import java.io.IOException;

public class Program3 extends FileManager {
    public static void main(String[] args) throws IOException {
        // Question 1
        System.out.println(FileManager.isFileExists("/Users/finns/Desktop/text.rtf"));
        // Question 2
        FileManager.createNewFile("/Users/finns/Desktop","text");
        // Question 4
        FileManager.deleteFile("/Users/finns/Desktop","text");
        // Question 5
         FileManager.isFolder("/Users/finns/Desktop/text");
        // Question 6
        System.out.println(FileManager.getAllFileName("/Users/finns/Desktop/test"));
        // Question 10
//        FileManager.createNewFolder("/Users/finns/Desktop/test3");
        // Question 8
//        FileManager.moveFile("/Users/finns/Desktop/test/text.rtf","/Users/finns/Desktop/Dich");

    }



}

package org.example;

import java.util.Scanner;

public class MyNews {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        News news = new News();
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Publish Date: ");
                    String publishDate = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Content: ");
                    String content = scanner.nextLine();
                    System.out.print("Enter 3 Rates: ");
                    int[] rates = new int[3];
                    for (int i = 0; i < 3; i++) {
                        rates[i] = scanner.nextInt();
                    }
                    news.setID(1); // You can set ID here
                    news.setTitle(title);
                    news.setPublishDate(publishDate);
                    news.setAuthor(author);
                    news.setContent(content);
                    news.setRates(rates);
                    break;
                case 2:
                    news.Display();
                    break;
                case 3:
                    news.Calculate();
                    news.Display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
    }
}

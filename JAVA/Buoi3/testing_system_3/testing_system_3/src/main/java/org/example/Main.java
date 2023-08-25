package org.example;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*======== EX1 =========== */

        // Question1

        Account account1 = new Account(1, "Pham Minh Tuan", 5240.5f);
        Account account2 = new Account(2, "Nguyen Quang Huy", 10970.055f);

        int wageAccount1 = (int) account1.wage;
        int wageAccount2 = (int) account2.wage;

        System.out.println(wageAccount1);
        System.out.println(wageAccount2);

        // Question 2

        Random rd = new Random();
        int numRandom = rd.nextInt(0, 100000);
        String changeText = Integer.toString(numRandom);
        while (changeText.length() < 5) {
            changeText = "0" + changeText;
        }


        System.out.println(changeText);


        //Question 3
        int changeNum = Integer.parseInt(changeText);
        int twoLastNumber = changeNum % 100;

        System.out.println(twoLastNumber);

        //Question 4
        division(1,0);

        /* ========== EX2 ========== */

        Account[] listAccount = new Account[5];

        for(int i = 0; i < 5; i++){
            Account account = new Account();
            account.email = "Email : " + i;
            account.userName = "UserName : " + i;
            account.fullName = "FullName : " + i;
            account.createDate = new Date();

            listAccount[i] = account;
        }

        /* =========== EX3 =========== */

        // Question 1
        Integer salaryInteger = 5000;
        float salaryFloat = salaryInteger.floatValue();
        System.out.printf("Salary: %.2f\n", salaryFloat);

        // Question 2
        String thisString = "1234567";
        int thisNumber = Integer.parseInt(thisString);
        System.out.println(thisNumber);

        //Question 3
        Integer thisInterger = Integer.valueOf("1234567");
        int thisNumber2 = thisInterger.intValue();
        System.out.println(thisNumber2);

        /* ============ EX4 =========== */

        // Question 1
        String stringOne = "Im am Superman";
        System.out.println(stringOne.length());

        // Question 2

        String string1 = "Im am";
        String string2 = "Superman";
        String matchString = string1 + string2;
        System.out.println(matchString);

        // Question 3

       String myName = capitalizeFirstLetter("phạm minh tuấn");
        System.out.println(myName);

        // Question 4
        String myName2 = "Nam";

        int dem = 0;
        while (myName2.length() > dem ) {
            char kitu = myName2.charAt(dem);
            System.out.println("Kí tự thứ " + (dem + 1) + " là " + kitu  );
            dem ++;
        }

        // Question 5

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Họ : ");
        String lastName = scanner.nextLine();
        System.out.println("Nhập Tên");
        String firstName = scanner.nextLine();
        if(isInteger(lastName) != true && isInteger(firstName) != true ) {
            if(lastName.length() > 0 && firstName.length() > 0){
                System.out.println("Họ và tên của mày là : " + lastName + " " + firstName);
            }else if ( lastName.length() > 0 && firstName.length() < 0 ) {
                System.out.println("Họ của mày là " + lastName);
            }else {
                System.out.println("Tên của mày kà : " + firstName);
            }
        }else{
            System.out.println("Vui lòng nhập đúng định dạng tuổi");
        }

        // Question 6
        System.out.print("Nhập họ và tên đầy đủ: ");
        String fullName = scanner.nextLine();

        String[] nameParts = parseName(fullName);

        if (nameParts.length == 3) {
            System.out.println("Họ là: " + nameParts[0]);
            System.out.println("Tên đệm là: " + nameParts[1]);
            System.out.println("Tên là: " + nameParts[2]);
        } else {
            System.out.println("Vui lòng nhập đúng định dạng Họ Tên Đệm");
        }

        // Question 8
        String[] stringArray = {
                "Java Programming",
                "Python Development",
                "Java Language",
                "Web Development"
        };

        for (String str : stringArray) {
            if (str.contains("Java")) {
                System.out.println("Chuỗi chứa 'Java': " + str);
            }
        }

        // Question 10

        String str1 = "word";
        String str2 = "drow";

        if (areStringsReversed(str1, str2)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }

        // Question 11
        String input = "Đã quá đi âaaaaaaaaaaaaaaaaa";

        int count = countCharacter(input, 'a');

        System.out.println("Số lần xuất hiện của ký tự 'a' trong chuỗi: " + count);


        // Question 12
        String chuoiBanDau = "Hello, World!";
        String chuoiChuyen = reverseString(input);

        System.out.println("Chuỗi ban đầu: " + chuoiBanDau);
        System.out.println("Chuỗi sau khi đảo ngược: " + chuoiChuyen);

        // Question 13

        String input4 = "123";
        String input5 = "a1bc";
        String input6 = null;


        System.out.println(hasDigits(input4));
        System.out.println(hasDigits(input5));
        System.out.println(hasDigits(input6));

        // Question 14
        String input7 = "VTI Academy";
        char targetChar = 'e';
        char replacementChar = '*';

        String result = replaceChar(input7, targetChar, replacementChar);

        System.out.println("Kết quả sau khi thay thế: " + result);
    }


    // Hàm
    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void division(int a, int b) {
        if(b != 0) {
            float convertA = (float) a;
            float convertB = (float) b;

            float result = convertA / convertB;

            System.out.println(result);
        }else{
            System.out.println("Không thể chia cho 0");
        }
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                String restOfWord = word.substring(1).toLowerCase();
                result.append(firstChar).append(restOfWord).append(" ");
            }
        }

        return result.toString().trim();
    }


    public static String[] parseName(String fullName) {
        return fullName.split(" ");
    }

    public static boolean areStringsReversed(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(str2.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static int countCharacter(String str, char character) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean hasDigits(String str) {
        if (str == null) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static String replaceChar(String str, char targetChar, char replacementChar) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == targetChar) {
                charArray[i] = replacementChar;
            }
        }
        return new String(charArray);
    }
}


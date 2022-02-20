package lesson.basic;

import java.io.InputStream;
import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        String aWord = "aWordnazodo";
        int ten = 10;

        print(capitalize(aWord)); //method invocation
        int fifty = multiplyByFive(ten);
        print(fifty);

        int age = 0;
        InputStream readfromSystem = System.in;
        Scanner scanner = new Scanner(readfromSystem);

        System.out.println("What is your year or birth:"); // reads an int from the command line
        age = scanner.nextInt();

        print(multiplyByFive(age));
    }
    /**
     * Methods hava a signature
     * - The return type // not optional
     * - method name // not optional
     * - arguements // optional
     */
    static String capitalize(String stringToCapitalize){
        return stringToCapitalize.toUpperCase();
    }

    static int multiplyByFive(int numberToMultiply){
        return numberToMultiply * 5;
    }

    static void print(String stringToPrint){
        System.out.println(stringToPrint);
    }

    static void print(int intToPrint){
        System.out.println(intToPrint);
    }
}

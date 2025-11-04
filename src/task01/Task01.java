package task01;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(EnterEmailHandler.getEmail(scanner));
        } catch (NotCorrectEmailFormatException e) {
            System.out.println("There were errors when entering email:");
            e.getErrors().forEach(System.out::println);
        } finally {
            scanner.close();
        }
    }

}

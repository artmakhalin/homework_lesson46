package task01;

import java.util.Scanner;

public class EnterEmailHandler {
    private static NotCorrectEmailFormatException notCorrectEmailFormatException = new NotCorrectEmailFormatException();

    public static String getEmail(Scanner scanner) {
        notCorrectEmailFormatException.clearErrors();
        System.out.println("Enter email [min 5 characters, should contain '@', should not start or end with '@']:");
        String result = scanner.nextLine();
        if (result.length() < 5) {
            notCorrectEmailFormatException.addError("Less than 5 characters in email");
        }
        if (!result.contains("@")) {
            notCorrectEmailFormatException.addError("Missing '@' in email");
        }
        if (result.startsWith("@")) {
            notCorrectEmailFormatException.addError("Email starts with '@'");
        }
        if (result.endsWith("@")) {
            notCorrectEmailFormatException.addError("Email ends with '@'");
        }
        if (notCorrectEmailFormatException.isError()) {
            throw notCorrectEmailFormatException;
        }
        return result;
    }
}

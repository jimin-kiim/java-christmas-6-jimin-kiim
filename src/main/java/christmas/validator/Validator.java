package christmas.validator;

import christmas.messages.ErrorMessage;

public class Validator {
    private static void print(String message) {
        System.out.println(message);
    }
    public static boolean isInt(String input) {
        if (input != null && input.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static void validateDateRange() {

    }
}

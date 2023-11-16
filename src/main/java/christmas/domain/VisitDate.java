package christmas.domain;

public class VisitDate {
    int visitDate;
    private final String IS_DIGIT_REGEX = "^[0-9]+$";

    public VisitDate(String input) {
        visitDate = validateIsInt(input);
        validateDateRange();
    }

    private int validateIsInt(String input) {
        if (input == null || input.matches(IS_DIGIT_REGEX)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException();
    }

    private void validateDateRange() {
        if (0 < visitDate && visitDate < 32) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public int getValue() {
        return visitDate;
    }
}

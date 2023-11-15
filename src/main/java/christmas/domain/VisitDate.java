package christmas.domain;

public class VisitDate {
    int visitDate;

    public VisitDate(String input) {
        visitDate = validateIsInt(input);
        validateDateRange();
    }

    private int validateIsInt(String input) {
        if (input == null || input.matches("^[0-9]+$")) {
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

package christmas.domain;

import christmas.constants.Menu;

import java.util.Arrays;

public class OrderItem {
    String name;
    int quantity;
    private static final String IS_DIGIT_REGEX = "^[0-9]+$";

    public OrderItem(String name, String quantity) {
        this.name = name;
        validateMenu(name);
        this.quantity = validateIsInt(quantity);
        validateQuantityRange(this.quantity);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    private int validateIsInt(String input) {
        if (input == null || !input.matches(IS_DIGIT_REGEX)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    private void validateMenu(String menu) {
        Menu[] menus = Menu.values();
        if (!Arrays.stream(menus).anyMatch(m -> m.getName().equals(menu))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateQuantityRange(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }
    }
}

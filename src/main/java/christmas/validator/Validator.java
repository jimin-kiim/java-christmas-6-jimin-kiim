package christmas.validator;

import christmas.domain.Menu;
import christmas.domain.OrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static boolean validateIsInt(String input) {
        if (input != null && input.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static boolean validateDateRange(int input) {
        if (0 < input && input < 32) {
            return true;
        }
        return false;
    }


    public static boolean validateOrder(String input) {
        List<String> orders = Arrays.asList(input.split("\\s*,\\s*"));
        List<String> menuAndQuantity;
        List<String> menuNames = new ArrayList<>();
        int totalQuantity = 0;
        for (String order: orders) {
            menuAndQuantity = Arrays.asList(order.split("\\s*-\\s*"));
            if(!Validator.validateMenuAndQuantity(menuAndQuantity)) return false;
            menuNames.add(menuAndQuantity.get(0));
            totalQuantity += Integer.parseInt(menuAndQuantity.get(1));
        }
        if (!validateDuplicateMenu(menuNames)) return false;
        if (!validateTotalQuantity(totalQuantity)) return false;
        return true;
    }

    public static boolean validateMenuAndQuantity(List<String> menuAndQuantity) {
        if (!validateMenu(menuAndQuantity.get(0))) return false;
        if (!validateIsInt(menuAndQuantity.get(1))) return false;
        if (!validateQuantityRange(menuAndQuantity.get(1))) return false;
        return true;
    }

    private static boolean validateMenu(String menu) {
        Menu[] menus = Menu.values();
        if (Arrays.stream(menus).anyMatch(m -> m.getName().equals(menu))) {
            return true;
        }
        return false;
    }

    private static boolean validateQuantityRange(String quantity) {
        if (Integer.parseInt(quantity) > 0) {
            return true;
        }
        return false;
    }

    private static boolean validateDuplicateMenu(List<String> menuNames) {
        if (menuNames.size() == menuNames.stream().distinct().count()) {
            return true;
        }
        return false;
    }

    private static boolean validateTotalQuantity(int totalQuantity) {
        if (totalQuantity > 20) return false;
        return true;
    }
}

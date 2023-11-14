package christmas.validator;

import christmas.domain.Menu;
import christmas.domain.OrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
//    private static void print(String message) {
//        System.out.println(message);
//    }
    public static boolean validateIsInt(String input) {
        if (input != null && input.matches("^[0-9]+$")) {
            return true;
        }
//        System.out.println("validateIsInt");
        return false;
    }

    public static boolean validateDateRange(int input) {
        if (0 < input && input < 32) {
            return true;
        }
        return false;
    }


    public static boolean validateOrder(String input) {
        boolean isValid;
        List<String> orders = Arrays.asList(input.split("\\s*,\\s*"));
        List<String> menuAndQuantity;
        List<String> menuNames = new ArrayList<>();
        for (String order: orders) {
            menuAndQuantity = Arrays.asList(order.split("\\s*-\\s*"));
            isValid = Validator.validateMenuAndQuantity(menuAndQuantity);
            if (!isValid) return false;
            menuNames.add(menuAndQuantity.get(0));
        }
        validateDuplicateMenu(menuNames);
        return true;
    }

    public static boolean validateMenuAndQuantity(List<String> menuAndQuantity) {
        boolean isValid;
        isValid = validateMenu(menuAndQuantity.get(0));
        if (isValid) {
            isValid = validateIsInt(menuAndQuantity.get(1));
        }
        if (isValid) {
            isValid = validateQuantityRange(menuAndQuantity.get(1));
        }
        if (isValid) {
            return true;
        }
//        System.out.println("validateMenuAndQuantity");
        return false;
    }

    private static boolean validateMenu(String menu) {
        Menu[] menus = Menu.values();
        if (Arrays.stream(menus).anyMatch(m -> m.getName().equals(menu))) {
            return true;
        }
//        System.out.println("validateMenu");
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
            return false;
        }
        return true;
    }
}

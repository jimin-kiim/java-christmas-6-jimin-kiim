package christmas.view;

import christmas.domain.OrderItem;
import christmas.messages.ErrorMessage;
import christmas.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int getVisitDate() {
        String input = "";
        boolean isValid = false;
        do {
            try {
                input = readLine();
                Validator.validateIsInt(input);
                isValid = Validator.validateDateRange(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_DATE.getMessage());
            }
        } while (!isValid);

        return Integer.parseInt(input);
    }

    public static List<OrderItem> getOrder() {
        String input;
        boolean isValid = false;
        List<OrderItem> orderItemList = new ArrayList<>();
        do {
            try {
                input = readLine();
                isValid = Validator.validateOrder(input);
                if (isValid) orderItemList = processInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_ORDER.getMessage());
            }
        } while (!isValid);

        return orderItemList;
    }

    private static List<OrderItem> processInput(String input) {
        List<OrderItem> orderItemList = new ArrayList<>();;
        List<String> orders = Arrays.asList(input.split("\\s*,\\s*"));
        for (String order: orders) {
            List<String> menuAndQuantity = Arrays.asList(order.split("\\s*-\\s*"));
            String menu = menuAndQuantity.get(0);
            int quantity = Integer.parseInt(menuAndQuantity.get(1));
            orderItemList.add(new OrderItem(menu, quantity));
        }
        return orderItemList;
    }
}

package christmas.domain;

import christmas.constants.Menu;
import christmas.constants.MenuType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Orders {
    private static final String ORDERS_SPLIT_REGEX = "\\s*,\\s*";
    private static final String ORDER_MENU_QUANTITY_SPLIT_REGEX = "\\s*-\\s*";
    private static final int ORDER_QUANTITY_MAX_LIMIT = 20;
    private List<OrderItem> orderItemList;

    public Orders(String input) {
        List<String> orders = Arrays.asList(input.split(ORDERS_SPLIT_REGEX));
        parseByOrder(orders);
    }

    private void parseByOrder(List<String> orders) {
        List<String> menuNames = new ArrayList<>();
        orderItemList = new ArrayList<>();
        int totalQuantity = 0;
        for (String order: orders) {
            List<String> menuAndQuantity = Arrays.asList(order.split(ORDER_MENU_QUANTITY_SPLIT_REGEX));
            try {
                orderItemList.add(new OrderItem(menuAndQuantity.get(0), menuAndQuantity.get(1)));
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            menuNames.add(menuAndQuantity.get(0));
            totalQuantity += Integer.parseInt(menuAndQuantity.get(1));
        }
        validateOrders(menuNames, totalQuantity);
    }

    private void validateOrders(List<String> menuNames, int totalQuantity) {
        validateDuplicateMenu(menuNames);
        validateNotJustBeverages(menuNames);
        validateTotalQuantity(totalQuantity);
    }

    private void validateDuplicateMenu(List<String> menuNames) {
        if (menuNames.size() != menuNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotJustBeverages(List<String> menuNames) {
        List<String> beverageNames = Arrays.stream(Menu.values())
                .filter(m -> m.getType().equals(MenuType.BEVERAGE.getValue()))
                .map(m -> m.getName())
                .toList();
        for (String menu: menuNames) {
            if (!beverageNames.contains(menu)) return;
        }
        throw new IllegalArgumentException();
    }

    private void validateTotalQuantity(int totalQuantity) {
        if (totalQuantity > ORDER_QUANTITY_MAX_LIMIT) throw new IllegalArgumentException();
    }

    public List<OrderItem> getValue() {
        return orderItemList;
    }
}

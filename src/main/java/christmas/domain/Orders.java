package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Orders {
    private List<OrderItem> orderItemList;

    public Orders(String input) {
        List<String> orders = Arrays.asList(input.split("\\s*,\\s*"));
        parseByOrder(orders);
    }

    private void parseByOrder(List<String> orders) {
        List<String> menuNames = new ArrayList<>();
        orderItemList = new ArrayList<>();
        int totalQuantity = 0;
        for (String order: orders) {
            List<String> menuAndQuantity = Arrays.asList(order.split("\\s*-\\s*"));
            try {
                orderItemList.add(new OrderItem(menuAndQuantity.get(0), menuAndQuantity.get(1)));
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            menuNames.add(menuAndQuantity.get(0));
            totalQuantity += Integer.parseInt(menuAndQuantity.get(1));
        }
        validateDuplicateMenu(menuNames);
        validateTotalQuantity(totalQuantity);
    }

    private void validateDuplicateMenu(List<String> menuNames) {
        if (menuNames.size() != menuNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTotalQuantity(int totalQuantity) {
        if (totalQuantity > 20) throw new IllegalArgumentException();
    }

    public List<OrderItem> getValue() {
        return orderItemList;
    }
}

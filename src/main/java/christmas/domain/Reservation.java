package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reservation {
    private VisitDate visitDate;
    private List<OrderItem> orderItemList;
    private int prePromotionTotal = 0;

    public void storeVisitDate(VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    public void storeOrder(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
        calculatePrePromotionTotal();
    }

    private void calculatePrePromotionTotal() {
        for (OrderItem item: orderItemList) {
//            System.out.println(item.getName() + item.getAmount());
            Menu menu = Arrays.stream(Menu.values())
                    .filter(m -> m.getName().equals(item.getName()))
                    .findAny()
                    .get();

            int price = menu.getPrice();
            prePromotionTotal += price * item.getAmount();
        }
    }

    public int getPrePromotionTotal() {
        return prePromotionTotal;
    }
}

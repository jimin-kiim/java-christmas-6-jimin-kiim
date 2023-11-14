package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionManager {
    private List<Integer> weekdays = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31));
    public void applyGiftEvent(Reservation reservation) {
        int prePromotionTotal = reservation.getPrePromotionTotal();
        if (prePromotionTotal >= 120000) {
            reservation.addAppliedPromotionList(new Promotion("증정 이벤트", 25000));
            reservation.setGift(new OrderItem(Menu.CHAMPAGNE.getName(), 1));
        }
    }

    public void applyDdayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        if (visitDate <= 25) {
            int promotionAmount = 1000;
            promotionAmount += (visitDate - 1) * 100;
            reservation.addAppliedPromotionList(new Promotion("크리스마스 디데이 할인", promotionAmount));
        }
    }

    public void applyWeekdayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        if (!weekdays.contains(visitDate)) {
            return;
        }
        List<OrderItem> orderItemList = reservation.getOrderItemList();
        List<String> dessertNames = Arrays.stream(Menu.values())
                .filter(m -> m.getType().equals("디저트"))
                .map(m -> m.getName())
                .toList();
        int promotionAmount = 0;
        for (int i = 0; i < orderItemList.size(); i++) {
            if (dessertNames.contains(orderItemList.get(i).getName())) {
                promotionAmount += 2023 * orderItemList.get(i).getAmount();
            }
        }
        reservation.addAppliedPromotionList(new Promotion("평일 할인", promotionAmount));
    }
}

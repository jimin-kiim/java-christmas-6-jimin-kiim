package christmas.domain;

import christmas.constants.Badge;
import christmas.constants.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionManager {
    private List<Integer> weekdays = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31));
    private List<Integer> starredDays = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 31));

    public void applyGiftEvent(Reservation reservation) {
        int prePromotionTotal = reservation.getPrePromotionTotal();
        if (prePromotionTotal >= 120000) {
            reservation.addAppliedPromotionList(new Promotion("증정 이벤트", 25000, true));
            reservation.setGift(new OrderItem(Menu.CHAMPAGNE.getName(), "1"));
        }
    }

    public void applyDdayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        if (visitDate <= 25) {
            int promotionAmount = 1000;
            promotionAmount += (visitDate - 1) * 100;
            reservation.addAppliedPromotionList(new Promotion("크리스마스 디데이 할인", promotionAmount, false));
        }
    }

    public void applyWeekdayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        int promotionAmount = getWeekendWeekdayPromotionAmount(reservation, "디저트");
        if (!weekdays.contains(visitDate) || promotionAmount == 0) {
            return;
        }
        reservation.addAppliedPromotionList(new Promotion("평일 할인", promotionAmount, false));
    }

    public void applyWeekendEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        int promotionAmount = getWeekendWeekdayPromotionAmount(reservation, "메인");
        if (weekdays.contains(visitDate) || promotionAmount == 0) {
            return;
        }
        reservation.addAppliedPromotionList(new Promotion("주말 할인", promotionAmount, false));
    }

    private int getWeekendWeekdayPromotionAmount(Reservation reservation, String type) {
        int promotionAmount = 0;
        List<OrderItem> orderItemList = reservation.getOrderItemList();
        List<String> mainNames = Arrays.stream(Menu.values())
                .filter(m -> m.getType().equals(type))
                .map(m -> m.getName())
                .toList();

        for (int i = 0; i < orderItemList.size(); i++) {
            if (mainNames.contains(orderItemList.get(i).getName())) {
                promotionAmount += 2023 * orderItemList.get(i).getQuantity();
            }
        }
        return promotionAmount;
    }

    public void applyStarredDayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        if (starredDays.contains(visitDate)) {
            reservation.addAppliedPromotionList(new Promotion("특별 할인", 1000, false));
        }
    }

    public void applyBadgeEvent(Reservation reservation) {
        int totalPromotionAmount = reservation.getTotalPromotionAmount();
        if (totalPromotionAmount >= Badge.FIRST.getAmount()) {
            reservation.setBadge(Badge.FIRST.getName());
            return;
        }
        if (totalPromotionAmount >= Badge.SECOND.getAmount()) {
            reservation.setBadge(Badge.SECOND.getName());
            return;
        }
        if (totalPromotionAmount >= Badge.THIRD.getAmount()) {
            reservation.setBadge(Badge.THIRD.getName());
        }
    }
}

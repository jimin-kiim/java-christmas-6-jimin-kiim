package christmas.domain;

import christmas.constants.Badge;
import christmas.constants.Menu;
import christmas.constants.MenuType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionManager implements PromotionManagerInterface {
    public void applyGiftEvent(Reservation reservation) {
        int prePromotionTotal = reservation.getPrePromotionTotal();
        if (prePromotionTotal >= GIFT_EVENT_THRESHOLD_VALUE) {
            reservation.addAppliedPromotionList(new Promotion(GIFT_EVENT_TITLE, GIFT_EVENT_DISCOUNT_VALUE, GIFT_EVENT_EVENT_IS_GIVING_GIFT));
            reservation.setGift(new OrderItem(GIFT_TITLE, GIFT_QUANTITY));
        }
    }

    public void applyDdayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        if (visitDate <= DDAY_EVENT_THRESHOLD_VALUE) {
            int promotionAmount = DDAY_EVENT_DISCOUNT_BASE_VALUE;
            promotionAmount += (visitDate - DDAY_EVENT_INTERVAL) * DDAY_EVENT_DISCOUNT_WEIGHT;
            reservation.addAppliedPromotionList(new Promotion(DDAY_EVENT_TITLE, promotionAmount, DDAY_EVENT_IS_GIVING_GIFT));
        }
    }

    public void applyWeekdayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        int promotionAmount = getWeekendWeekdayPromotionAmount(reservation, MenuType.DESSERT.getValue());
        if (!WEEKDAYS.contains(visitDate) || promotionAmount == 0) {
            return;
        }
        reservation.addAppliedPromotionList(new Promotion(WEEKDAY_EVENT_TITLE, promotionAmount, WEEKDAY_EVENT_IS_GIVING_GIFT));
    }

    public void applyWeekendEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        int promotionAmount = getWeekendWeekdayPromotionAmount(reservation, MenuType.MAIN.getValue());
        if (WEEKDAYS.contains(visitDate) || promotionAmount == 0) {
            return;
        }
        reservation.addAppliedPromotionList(new Promotion(WEEKEND_EVENT_TITLE, promotionAmount, WEEKEND_EVENT_IS_GIVING_GIFT));
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
                promotionAmount += WEEKDAY_WEEKEND_EVENT_DISCOUNT_WEIGHT * orderItemList.get(i).getQuantity();
            }
        }
        return promotionAmount;
    }

    public void applyStarredDayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        if (STARRED_DAYS.contains(visitDate)) {
            reservation.addAppliedPromotionList(new Promotion(STARRED_DAY_EVENT_TITLE, STARRED_DAY_EVENT_DISCOUNT_VALUE, STARRED_DAY_EVENT_IS_GIVING_GIFT));
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

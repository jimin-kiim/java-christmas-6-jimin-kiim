package christmas.domain;

import christmas.constants.Badge;
import christmas.constants.Menu;
import christmas.constants.MenuType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionManager {
    private static final String GIFT_EVENT_TITLE = "증정 이벤트";
    private static final int GIFT_EVENT_THRESHOLD_VALUE = 120000;
    private static final int GIFT_EVENT_DISCOUNT_VALUE = 25000;
    private static final String GIFT_TITLE = Menu.CHAMPAGNE.getName();
    private static final String GIFT_QUANTITY = "1";
    private static final boolean GIFT_EVENT_EVENT_IS_GIVING_GIFT = true;

    private static final String DDAY_EVENT_TITLE = "크리스마스 디데이 할인";
    private static final int DDAY_EVENT_THRESHOLD_VALUE = 25;
    private static final int DDAY_EVENT_INTERVAL = 1;
    private static final int DDAY_EVENT_DISCOUNT_BASE_VALUE = 1000;
    private static final int DDAY_EVENT_DISCOUNT_WEIGHT = 100;
    private static final boolean DDAY_EVENT_IS_GIVING_GIFT = false;

    private static final String WEEKDAY_EVENT_TITLE = "평일 할인";
    private static final String WEEKEND_EVENT_TITLE = "주말 할인";
    private static final int WEEKDAY_WEEKEND_EVENT_DISCOUNT_WEIGHT = 2023;
    private static final boolean WEEKDAY_EVENT_IS_GIVING_GIFT = false;
    private static final boolean WEEKEND_EVENT_IS_GIVING_GIFT = false;

    private static final String STARRED_DAY_EVENT_TITLE = "특별 할인";
    private static final int STARRED_DAY_EVENT_DISCOUNT_VALUE = 1000;
    private static final boolean STARRED_DAY_EVENT_IS_GIVING_GIFT = false;

    private List<Integer> weekdays = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31));
    private List<Integer> starredDays = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 31));

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
        if (!weekdays.contains(visitDate) || promotionAmount == 0) {
            return;
        }
        reservation.addAppliedPromotionList(new Promotion(WEEKDAY_EVENT_TITLE, promotionAmount, WEEKDAY_EVENT_IS_GIVING_GIFT));
    }

    public void applyWeekendEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        int promotionAmount = getWeekendWeekdayPromotionAmount(reservation, MenuType.MAIN.getValue());
        if (weekdays.contains(visitDate) || promotionAmount == 0) {
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
        if (starredDays.contains(visitDate)) {
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

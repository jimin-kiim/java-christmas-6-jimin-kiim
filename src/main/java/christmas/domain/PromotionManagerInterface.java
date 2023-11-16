package christmas.domain;

import christmas.constants.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface PromotionManagerInterface {
    String GIFT_EVENT_TITLE = "증정 이벤트";
    int GIFT_EVENT_THRESHOLD_VALUE = 120000;
    int GIFT_EVENT_DISCOUNT_VALUE = 25000;
    String GIFT_TITLE = Menu.CHAMPAGNE.getName();
    String GIFT_QUANTITY = "1";
    boolean GIFT_EVENT_EVENT_IS_GIVING_GIFT = true;

    String DDAY_EVENT_TITLE = "크리스마스 디데이 할인";
    int DDAY_EVENT_THRESHOLD_VALUE = 25;
    int DDAY_EVENT_INTERVAL = 1;
    int DDAY_EVENT_DISCOUNT_BASE_VALUE = 1000;
    int DDAY_EVENT_DISCOUNT_WEIGHT = 100;
    boolean DDAY_EVENT_IS_GIVING_GIFT = false;

    String WEEKDAY_EVENT_TITLE = "평일 할인";
    String WEEKEND_EVENT_TITLE = "주말 할인";
    int WEEKDAY_WEEKEND_EVENT_DISCOUNT_WEIGHT = 2023;
    boolean WEEKDAY_EVENT_IS_GIVING_GIFT = false;
    boolean WEEKEND_EVENT_IS_GIVING_GIFT = false;
    List<Integer> WEEKDAYS = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31));
    List<Integer> STARRED_DAYS = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 31));

    String STARRED_DAY_EVENT_TITLE = "특별 할인";
    int STARRED_DAY_EVENT_DISCOUNT_VALUE = 1000;
    boolean STARRED_DAY_EVENT_IS_GIVING_GIFT = false;
}

package christmas.view;

import christmas.domain.OrderItem;
import christmas.domain.Promotion;
import christmas.messages.Message;

import java.util.List;

public class OutputView {
    private static final String NONE = "없음";
    private static final String CURRENCY_UNIT = "원";
    private static final String COUNTING_UNIT = "개";
    private static final String NEGATIVE_SIGN = "-";
    private static final String FIND_THREE_DIGIT_NUMBER_REGEX = "\\B(?=(\\d{3})+(?!\\d))";

    private static void print(String message) {
        System.out.println(message);
    }
    private static void printBlankLine () {print("");}

    public static void printWelcomingMessage() {
        print(Message.WELCOME_MESSAGE.getMessage());
    }

    public static void askVisitDate() {
        print(Message.ASK_VISIT_DATE.getMessage());
    }

    public static void askOrder() {
        print(Message.ASK_ORDER.getMessage());
    }

    public static void printPromotionViewTitle() {
        print(Message.PROMOTION_VIEW_TITLE.getMessage());
    }

    public static void printOrderList(List<OrderItem> orderItemList) {
        printBlankLine();
        print(Message.ORDER_LIST_TITLE.getMessage());
        for (OrderItem item: orderItemList) {
            print(item.getName() + " " + item.getQuantity() + COUNTING_UNIT);
        }
    }

    public static void printPrePromotionTotal(int amount) {
        printBlankLine();
        print(Message.PRE_PROMOTION_TOTAL_TITLE.getMessage());
        String outputAmount = separateByThousands(amount);
        print(outputAmount + CURRENCY_UNIT);
    }

    public static void printGiftMenu(OrderItem gift) {
        printBlankLine();
        print(Message.GIFT_TITLE.getMessage());
        if (gift != null) {
            String name = gift.getName();
            int amount = gift.getQuantity();
            print(name + " " + amount + COUNTING_UNIT);
            return;
        }
        print(NONE);
    }

    public static void printPromotionList(List<Promotion> promotionList) {
        printBlankLine();
        print(Message.PROMOTION_LIST_TITLE.getMessage());
        if (promotionList.size() != 0) {
            for (Promotion promotion: promotionList) {
                String name = promotion.getName();
                int amount = promotion.getAmount();
                String outputAmount = separateByThousands(amount);
                print(name + ": " + NEGATIVE_SIGN + outputAmount + CURRENCY_UNIT);
            }
            return;
        }
        print(NONE);
    }

    public static void printTotalPromotionAmount(int amount) {
        printBlankLine();
        print(Message.TOTAL_PROMOTION_AMOUNT_TITLE.getMessage());
        String outputAmount = separateByThousands(amount);
        if (amount > 0 ) {
            print(NEGATIVE_SIGN + outputAmount + CURRENCY_UNIT);
            return;
        }
        print(outputAmount + CURRENCY_UNIT);
    }

    public static void printPostPromotionTotal(int amount) {
        printBlankLine();
        print(Message.POST_PROMOTION_TOTAL_TITLE.getMessage());
        String outputAmount = separateByThousands(amount);
        print(outputAmount + CURRENCY_UNIT);
    }

    public static void printBadge(String badge) {
        printBlankLine();
        print(Message.BADGE_TITLE.getMessage());
        if (badge != null) {
            print(badge);
            return;
        }
        print(NONE);
    }

    private static String separateByThousands(int amount) {
        String outputAmount = Integer.toString(amount);
        return outputAmount.replaceAll(FIND_THREE_DIGIT_NUMBER_REGEX, ",");
    }
}

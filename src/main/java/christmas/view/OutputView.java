package christmas.view;

import christmas.domain.OrderItem;
import christmas.domain.Promotion;
import christmas.messages.Message;

import java.util.List;

public class OutputView {
    private static final String NONE = "없음";
    private static void print(String message) {
        System.out.println(message);
    }

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
        print("");
        print(Message.ORDER_LIST_TITLE.getMessage());
        for (OrderItem item: orderItemList) {
            print(item.getName() + " " + item.getQuantity() + "개");
        }
    }

    public static void printPrePromotionTotal(int amount) {
        print("");
        print(Message.PRE_PROMOTION_TOTAL_TITLE.getMessage());
        String outputAmount = separateByThousands(amount);
        print(outputAmount + "원");
    }

    public static void printGiftMenu(OrderItem gift) {
        print("");
        print(Message.GIFT_TITLE.getMessage());
        if (gift != null) {
            String name = gift.getName();
            int amount = gift.getQuantity();
            print(name + " " + amount +"개");
            return;
        }
        print("없음");
    }

    public static void printPromotionList(List<Promotion> promotionList) {
        print("");
        print(Message.PROMOTION_LIST_TITLE.getMessage());
        if (promotionList.size() != 0) {
            for (Promotion promotion: promotionList) {
                String name = promotion.getName();
                int amount = promotion.getAmount();
                String outputAmount = separateByThousands(amount);
                print(name + ": -" + outputAmount + "원");
            }
            return;
        }
        print(NONE);
    }

    public static void printTotalPromotionAmount(int amount) {
        print("");
        print(Message.TOTAL_PROMOTION_AMOUNT_TITLE.getMessage());
        String outputAmount = separateByThousands(amount);
        if (amount > 0 ) {
            print("-" + outputAmount + "원");
            return;
        }
        print(outputAmount + "원");
    }

    public static void printPostPromotionTotal(int amount) {
        print("");
        print(Message.POST_PROMOTION_TOTAL_TITLE.getMessage());
        String outputAmount = separateByThousands(amount);
        print(outputAmount + "원");
    }

    public static void printBadge(String badge) {
        print("");
        print(Message.BADGE_TITLE.getMessage());
        if (badge != null) {
            print(badge);
            return;
        }
        print(NONE);
    }

    private static String separateByThousands(int amount) {
        String outputAmount = Integer.toString(amount);
        return outputAmount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    }
}

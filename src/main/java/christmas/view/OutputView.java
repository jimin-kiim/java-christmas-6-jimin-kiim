package christmas.view;

import christmas.domain.OrderItem;
import christmas.messages.Message;

public class OutputView {
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
    }

    public static void printPrePromotionTotal(int prePromotionTotal) {
        print(Message.PRE_PROMOTION_TOTAL_TITLE.getMessage());
        String output = Integer.toString(prePromotionTotal);
        output = output.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        print(output+"원");
    }

    public static void printGiftMenu(OrderItem gift) {
        print(Message.GIFT_TITLE.getMessage());
        if (gift != null) {
            String name = gift.getName();
            int amount = gift.getAmount();
            print(name + " " + amount +"개");
        }
        if (gift == null) {
            print("없음");
        }
    }
}

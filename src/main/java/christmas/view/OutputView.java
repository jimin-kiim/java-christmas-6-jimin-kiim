package christmas.view;

import christmas.domain.OrderItem;
import christmas.domain.Promotion;
import christmas.messages.Message;

import java.util.List;

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

    public static void printOrderList(List<OrderItem> orderItemList) {
        print(Message.ORDER_LIST_TITLE.getMessage());
        for (OrderItem item: orderItemList) {
            print(item.getName() + " " + item.getAmount() + "개");
        }
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

    public static void printPromotionList(List<Promotion> promotionList) {
        print(Message.PROMOTION_LIST_TITLE.getMessage());
        if (promotionList.size() != 0) {
            for (Promotion promotion: promotionList) {
                String name = promotion.getName();
                int amount = promotion.getAmount();
                String outputAmount = Integer.toString(amount);
                outputAmount = outputAmount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
                print(name + ": -" + outputAmount + "원");
            }
        }
        if (promotionList.size() == 0) {
            print("없음");
        }
    }

    public static void printTotalPromotionAmount(int amount) {
        print(Message.TOTAL_PROMOTION_AMOUNT_TITLE.getMessage());
        String outputAmount = Integer.toString(amount);
        outputAmount = outputAmount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        print("-" + outputAmount + "원");
    }

    public static void printPostPromotionTotal(int amount) {
        print(Message.POST_PROMOTION_TOTAL_TITLE.getMessage());
        String outputAmount = Integer.toString(amount);
        outputAmount = outputAmount.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        print(outputAmount + "원");
    }
}

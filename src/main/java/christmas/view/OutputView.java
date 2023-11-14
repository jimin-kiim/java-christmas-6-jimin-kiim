package christmas.view;

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
}

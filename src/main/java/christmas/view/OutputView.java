package christmas.view;

import christmas.domain.OrderItem;
import christmas.domain.VisitDate;
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
}

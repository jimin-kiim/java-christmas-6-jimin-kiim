package christmas.view;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.messages.ErrorMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static VisitDate getVisitDate() {
        while(true) {
            try {
                return new VisitDate(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_DATE.getMessage());
            }
        }
    }

    public static Orders getOrder() {
        while(true) {
            try {
                return new Orders(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_ORDER.getMessage());
            }
        }
    }
}

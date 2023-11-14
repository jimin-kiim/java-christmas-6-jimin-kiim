package christmas.view;

import christmas.domain.OrderItem;
import christmas.domain.VisitDate;
import christmas.messages.ErrorMessage;
import christmas.validator.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static VisitDate getVisitDate() {
        String input;
        boolean isValid;
        do {
            input = readLine();
            isValid = Validator.isInt(input);
            if (!isValid) {
                System.out.println(ErrorMessage.INVALID_DATE.getMessage());
            }
        } while (!isValid);

        return new VisitDate(Integer.parseInt(input));
    }

//    public static void List<OrderItem> getOrder() {
//    }
}

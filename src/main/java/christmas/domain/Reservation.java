package christmas.domain;

import java.util.List;

public class Reservation {
    private VisitDate visitDate;
    public void storeVisitDate(VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    public void storeOrder(List<OrderItem> order) {
    }
}

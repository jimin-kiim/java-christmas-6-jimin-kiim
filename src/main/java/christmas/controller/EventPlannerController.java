package christmas.controller;

import christmas.domain.OrderItem;
import christmas.domain.PromotionManager;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventPlannerController {
    Reservation reservation;

    public void startProgram() {
        getReservation();
        applyPromotion();
        showReservationWithBenefits();
    }

    private void getReservation() {
        reservation = new Reservation();

        OutputView.printWelcomingMessage();

        OutputView.askVisitDate();
        VisitDate visitDate = InputView.getVisitDate();
//        reservation.storeVisitDate(visitDate);

//        OutputView.askOrder();
//        List<OrderItem> order = InputView.getOrder();
//        reservation.storeOrder(order);
    }

    private void applyPromotion() {

    }

    private void showReservationWithBenefits() {
        OutputView.printPromotionViewTitle();

        showOrderList();
        showTotalPriceBeforePromotion();
        showGiftMenus();
        showAppliedPromotionEvents();
        showTotalAppliedPromotionAmount();
        showTotalPriceAfterPromotion();
        showEventBadges();
    }

    private void showOrderList() {

    }

    private void showTotalPriceBeforePromotion() {

    }

    private void showGiftMenus() {

    }

    private void showAppliedPromotionEvents() {

    }

    private void showTotalAppliedPromotionAmount() {

    }

    private void showTotalPriceAfterPromotion () {

    }

    private void showEventBadges() {

    }
}

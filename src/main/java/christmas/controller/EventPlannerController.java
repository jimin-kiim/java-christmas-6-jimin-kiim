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
        reservation.storeVisitDate(visitDate);

        OutputView.askOrder();
        List<OrderItem> orderItemList = InputView.getOrder();
        reservation.storeOrder(orderItemList);
    }

    private void applyPromotion() {
        PromotionManager promotionManager = new PromotionManager();

//        promotionManager.applyGiftEvent(reservation);
//        promotionManager.applyDdayEvent(reservation);
//        promotionManager.applyWeekdayEvent(reservation);
//        promotionManager.applyWeekendEvent(reservation);
//        promotionManager.applyStarredDayEvent(reservation);
//        promotionManager.applyBadgeEvent(reservation);
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
        int prePromotionTotal = reservation.getPrePromotionTotal();
        OutputView.printPrePromotionTotal(prePromotionTotal);
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
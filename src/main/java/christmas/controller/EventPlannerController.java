package christmas.controller;

import christmas.domain.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventPlannerController {
    Reservation reservation;
    private static final int PROMOTION_THRESHOLD = 10000;

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
        reservation.storeVisitDate(visitDate.getValue());

        OutputView.askOrder();
        Orders orders = InputView.getOrder();
        reservation.storeOrder(orders.getValue());
    }

    private void applyPromotion() {
        int prePromotionTotal = reservation.getPrePromotionTotal();
        if (prePromotionTotal < PROMOTION_THRESHOLD) {
            return;
        }
        PromotionManager promotionManager = new PromotionManager();
        promotionManager.applyGiftEvent(reservation);
        promotionManager.applyDdayEvent(reservation);
        promotionManager.applyWeekdayEvent(reservation);
        promotionManager.applyWeekendEvent(reservation);
        promotionManager.applyStarredDayEvent(reservation);
        promotionManager.applyBadgeEvent(reservation);
    }

    private void showReservationWithBenefits() {
        OutputView.printPromotionViewTitle();

        showOrderList();
        showTotalPriceBeforePromotion();
        showGiftMenus();
        showAppliedPromotionEvents();
        showTotalAppliedPromotionAmount();
        showPostPromotionTotal();
        showEventBadges();
    }

    private void showOrderList() {
        List<OrderItem> orderItemList = reservation.getOrderItemList();
        OutputView.printOrderList(orderItemList);
    }

    private void showTotalPriceBeforePromotion() {
        int prePromotionTotal = reservation.getPrePromotionTotal();
        OutputView.printPrePromotionTotal(prePromotionTotal);
    }

    private void showGiftMenus() {
        OrderItem gift = reservation.getGift();
        OutputView.printGiftMenu(gift);
    }

    private void showAppliedPromotionEvents() {
        List<Promotion> promotionList = reservation.getPromotionList();
        OutputView.printPromotionList(promotionList);
    }

    private void showTotalAppliedPromotionAmount() {
        int totalPromotionAmount = reservation.getTotalPromotionAmount();
        OutputView.printTotalPromotionAmount(totalPromotionAmount);

    }

    private void showPostPromotionTotal () {
        int postPromotionTotal = reservation.getPostPromotionTotal();
        OutputView.printPostPromotionTotal(postPromotionTotal);
    }

    private void showEventBadges() {
        String badge = reservation.getBadge();
        OutputView.printBadge(badge);
    }
}

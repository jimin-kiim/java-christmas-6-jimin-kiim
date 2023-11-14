package christmas.controller;

import christmas.domain.OrderItem;
import christmas.domain.Promotion;
import christmas.domain.PromotionManager;
import christmas.domain.Reservation;
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
        int visitDate = InputView.getVisitDate();
        reservation.storeVisitDate(visitDate);

        OutputView.askOrder();
        List<OrderItem> orderItemList = InputView.getOrder();
        reservation.storeOrder(orderItemList);
    }

    private void applyPromotion() {
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

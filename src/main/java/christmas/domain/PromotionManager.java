package christmas.domain;

public class PromotionManager {
    public void applyGiftEvent(Reservation reservation) {
        int prePromotionTotal = reservation.getPrePromotionTotal();
        if (prePromotionTotal >= 120000) {
            reservation.addAppliedPromotionList(new Promotion("증정 이벤트", 25000));
            reservation.setGift(new OrderItem(Menu.CHAMPAGNE.getName(), 1));
        }
    }
}

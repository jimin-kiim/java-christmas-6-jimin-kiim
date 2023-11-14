package christmas.domain;

public class PromotionManager {
    public void applyGiftEvent(Reservation reservation) {
        int prePromotionTotal = reservation.getPrePromotionTotal();
        if (prePromotionTotal >= 120000) {
            reservation.addAppliedPromotionList(new Promotion("증정 이벤트", 25000));
            reservation.setGift(new OrderItem(Menu.CHAMPAGNE.getName(), 1));
        }
    }

    public void applyDdayEvent(Reservation reservation) {
        int visitDate = reservation.getVisitDate();
        if (visitDate <= 25) {
            int promotionAmount = 1000;
            promotionAmount += (visitDate - 1) * 100;
            reservation.addAppliedPromotionList(new Promotion("크리스마스 디데이 할인", promotionAmount));
        }
    }
}

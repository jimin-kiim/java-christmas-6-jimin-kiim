package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reservation {
    private int visitDate;
    private List<OrderItem> orderItemList;
    private int prePromotionTotal = 0;
    private int postPromotionTotal = 0;
    private int totalPromotionAmount = 0;
    private List<Promotion> promotionList;
    private OrderItem gift = null;
    private String badge = null;

    public void storeVisitDate(int visitDate) {
        this.visitDate = visitDate;
    }

    public void storeOrder(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
        calculatePrePromotionTotal();
        promotionList = new ArrayList<>();
    }

    private void calculatePrePromotionTotal() {
        for (OrderItem item: orderItemList) {
            Menu menu = Arrays.stream(Menu.values())
                    .filter(m -> m.getName().equals(item.getName()))
                    .findAny()
                    .get();

            int price = menu.getPrice();
            prePromotionTotal += price * item.getQuantity();
        }
        postPromotionTotal = prePromotionTotal;
    }

    public int getPrePromotionTotal() {
        return prePromotionTotal;
    }

    public void addAppliedPromotionList(Promotion promotion) {
        promotionList.add(promotion);
        int promotionAmount = promotion.getAmount();
        totalPromotionAmount += promotionAmount;
        if (promotion.getIsGift()) return;
        postPromotionTotal -= promotionAmount;
    }

    public void setGift(OrderItem orderItem) {
        gift = orderItem;
    }

    public OrderItem getGift() {
        return gift;
    }

    public int getVisitDate() {
        return visitDate;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public int getTotalPromotionAmount() {
        return totalPromotionAmount;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public int getPostPromotionTotal() {
        return postPromotionTotal;
    }

    public String getBadge() {
        return badge;
    }
}

package christmas.domain;

public class Promotion {
    private boolean isGift;
    private String name;
    private int amount;

    public Promotion(String name, int amount, boolean isGift) {
        this.name = name;
        this.amount = amount;
        this.isGift = isGift;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public boolean getIsGift() {
        return isGift;
    }
}

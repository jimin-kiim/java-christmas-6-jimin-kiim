package christmas.domain;

public class Promotion {
    private String name;
    private int amount;

    public Promotion(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}

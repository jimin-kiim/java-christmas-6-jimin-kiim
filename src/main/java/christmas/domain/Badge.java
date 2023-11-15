package christmas.domain;

public enum Badge {
    FIRST("산타", 20000),
    SECOND("트리",10000),
    THIRD("별", 5000);

    private String name;
    private int amount;

    Badge (String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}

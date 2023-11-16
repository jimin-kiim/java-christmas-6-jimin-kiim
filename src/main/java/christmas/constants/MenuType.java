package christmas.constants;

public enum MenuType {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private String value;

    MenuType (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

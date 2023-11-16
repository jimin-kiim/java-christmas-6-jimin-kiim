package christmas.constants;

public enum Menu {
    SOUP("양송이수프", 6000, MenuType.APPETIZER.getValue()),
    TAPAS("타파스", 5500, MenuType.APPETIZER.getValue()),
    SALAD("시저샐러드", 8000,  MenuType.APPETIZER.getValue()),

    STEAK("티본스테이크", 55000, MenuType.MAIN.getValue()),
    RIB("바비큐립", 54000, MenuType.MAIN.getValue()),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN.getValue()),
    CHRISTMAS_PASTA("크리스마스파스타", 25000,  MenuType.MAIN.getValue()),

    CAKE("초코케이크", 15000,  MenuType.DESSERT.getValue()),
    ICE_CREAM("아이스크림", 5000,  MenuType.DESSERT.getValue()),

    COKE("제로콜라", 3000, MenuType.BEVERAGE.getValue()),
    WINE("레드와인", 60000,  MenuType.BEVERAGE.getValue()),
    CHAMPAGNE("샴페인", 25000, MenuType.BEVERAGE.getValue());

    private String name;
    private int price;
    private String type;

    Menu (String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}

package christmas.domain;

public enum Menu {
    SOUP("양송이수프", 6000, "양송이수프(6,000)"),
    TAPAS("타파스", 5500, "타파스(5,500)"),
    SALAD("시저샐러드", 8000,  "시저샐러드(8,000)"),

    STEAK("티본스테이크", 55000, "티본스테이크(55,000)"),
    RIB("바비큐립", 54000, "바비큐립(54,000)"),
    SEAFOOD_PASTA("해산물파스타", 35000, "해산물파스타(35,000)"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000,  "크리스마스파스타(25,000)"),
    CAKE("초코케이크", 15000,  "초코케이크(15,000)"),
    ICE_CREAM("아이스크림", 5000,  "아이스크림(5,000)"),
    COKE("제로콜라", 3000, "제로콜라(3,000)"),
    WINE("레드와인", 60000,  "레드와인(60,000)"),
    CHAMPAGNE("샴페인", 25000, "샴페인(25,000)");

    private String name;
    private int price;
    private String message;


    Menu (String name, int price, String message) {
        this.name = name;
        this.price = price;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}

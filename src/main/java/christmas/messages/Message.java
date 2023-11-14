package christmas.messages;

public enum Message {
    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASK_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASK_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    ORDER_LIST_TITLE("<주문 메뉴>"),
    PRE_PROMOTION_TOTAL_TITLE("<할인 전 총주문 금액>"),
    GIFT_TITLE("<증정 메뉴>"),
    PROMOTION_LIST_TITLE("<혜택 내역>");

    private String message;

    Message(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}

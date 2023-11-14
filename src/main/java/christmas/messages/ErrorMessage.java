package christmas.messages;

public enum ErrorMessage {
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private String message;
    private String prefix = "[ERROR] ";

    ErrorMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return prefix + message;
    }
}

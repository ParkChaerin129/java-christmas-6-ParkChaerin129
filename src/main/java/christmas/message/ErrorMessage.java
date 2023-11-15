package christmas.message;

public enum ErrorMessage {

    ERROR_NOT_DAY_INTEGER("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_NOT_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_NOT_MENU_INTEGER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_NOT_MENU_RANGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_ONLY_DRINK("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_NOT_MENU_NAME("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_NOT_CORRECT_FORM("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_DUPLICATE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }
}

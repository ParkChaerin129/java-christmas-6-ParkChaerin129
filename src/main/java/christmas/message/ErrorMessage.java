package christmas.message;

public enum ErrorMessage {

    ERROR_NOT_INTEGER("[ERROR] 정수가 아닌 입력입니다."),
    ERROR_NOT_RANGE("[ERROR] 1과 31사이가 아닌 입력입니다."),
    ERROR_NOT_MENU_RANGE("[ERROR] 총 메뉴의 개수가 1에서 20 사이가 아닌 입력입니다."),
    ERROR_ONLY_DRINK("[ERROR] 음료만 시켰습니다."),
    ERROR_NOT_MENU_NAME("[ERROR] 메뉴 이름이 아닙니다."),
    ERROR_NOT_CORRECT_FORM("[ERROR] 올바른 형식이 아닙니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }
}

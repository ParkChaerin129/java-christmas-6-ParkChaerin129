package christmas.message;

public enum ErrorMessage {

    ERROR_NOT_INTEGER("[ERROR] 정수가 아닌 입력입니다."),
    ERROR_NOT_RANGE("[ERROR] 1과 31사이가 아닌 입력입니다");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }
}

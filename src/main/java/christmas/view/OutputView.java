package christmas.view;

import christmas.message.ErrorMessage;

public class OutputView {

    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }

    public void printErrorMessage(Exception error){
        System.out.println(error.toString());
    }
}

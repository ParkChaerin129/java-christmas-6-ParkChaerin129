package christmas.view;

import christmas.message.ErrorMessage;

public class OutputView {

    public void start(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }

    public void printErrorMessage(Exception error){
        System.out.println(error.toString());
    }
}

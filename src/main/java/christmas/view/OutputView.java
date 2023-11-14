package christmas.view;

import christmas.message.ErrorMessage;
import christmas.message.Menu;
import christmas.model.Day;
import christmas.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {

    public void start(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDate(Integer date){
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
    public void printMenu(Order order) {
        System.out.println("<주문 메뉴>");
        Map<Menu,Integer> orderMenu = order.getOrder();
        Set<Menu> menuNames = orderMenu.keySet();
        for(Menu menu : menuNames){
            System.out.println(menu.toString()+" "+orderMenu.get(menu)+"개");
        }
    }

    public void printErrorMessage(Exception error){
        System.out.println(error.toString());
    }
}

package christmas.controller;

import christmas.message.Menu;
import christmas.model.Day;
import christmas.model.Order;
import christmas.model.Pay;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneratePay {

    public Pay generatePay(Order order, Day day){
        Pay pay;
        Integer allPrice = calculateAllPrice(order);
        Integer xmasDDaySale = calculateXmasDDaySale(day);
        Integer daySale = calculateDaySale(order,day);
        pay= new Pay(allPrice,xmasDDaySale,daySale,day.isStarDay());
        return pay;
    }

    private Integer calculateAllPrice(Order order){
        Integer allPrice = 0;
        Map<Menu,Integer> orderMenus = order.getOrder();
        Set<Menu> menuNames = orderMenus.keySet();
        for(Menu menu : menuNames){
            allPrice+=menu.getPrice()*orderMenus.get(menu);
        }
        return allPrice;
    }

    private Integer calculateXmasDDaySale(Day day){
        if(day.getDate()>25){
            return 0;
        }
        return 900+day.getDate()*100;
    }

    private Integer calculateDaySale(Order order, Day day){
        if(day.isWeekend()){
            return 2023*order.getAmountByMenuKind("dessert");
        }
        return 2023*order.getAmountByMenuKind("main");
    }
}

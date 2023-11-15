package christmas.model;

import christmas.message.ErrorMessage;
import christmas.message.Menu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private Map<Menu,Integer> order;
    private Integer allMenuAmount = 0;
    private Map<String,Integer> orderMenuKind;

    public Order(){
        this.order = new LinkedHashMap<>();
        this.orderMenuKind = new HashMap<>();
    }

    public void addOrder(String menuName,Integer amount){
        Menu menu;
        try{
            menu = Menu.valueOf(menuName);}
        catch(Exception e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_MENU_NAME.toString());
        }
        if(order.containsKey(menu)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.toString());
        }
        order.put(menu,amount);
        allMenuAmount+=amount;
        String kind = menu.getKind();
        orderMenuKind.put(kind,orderMenuKind.getOrDefault(kind,0)+amount);
    }

    public boolean isValidOrder(){
        if(List.of("drink").containsAll(orderMenuKind.keySet())){
            throw new IllegalArgumentException(ErrorMessage.ERROR_ONLY_DRINK.toString());
        }
        if(allMenuAmount>20 | allMenuAmount<1){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_MENU_RANGE.toString());
        }
        return true;
    }

    public Map<Menu,Integer> getOrder(){
        return order;
    }

    public Map<String,Integer> getOrderMenuKind(){
        return orderMenuKind;
    }

    public Integer getAmountByMenuKind(String kind){
        return orderMenuKind.getOrDefault(kind,0);
    }

}

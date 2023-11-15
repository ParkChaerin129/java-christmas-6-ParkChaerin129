package christmas.view;

import christmas.message.Menu;
import christmas.model.Day;
import christmas.model.Order;
import christmas.model.Pay;

import java.text.NumberFormat;
import java.util.Locale;
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
        System.out.println("\n<주문 메뉴>");
        Map<Menu,Integer> orderMenu = order.getOrder();
        Set<Menu> menuNames = orderMenu.keySet();
        for(Menu menu : menuNames){
            System.out.println(menu.toString()+" "+orderMenu.get(menu)+"개");
        }
    }

    public void printPay(Pay pay,boolean isWeekend){
        printAllPrice(pay.getAllPrice());
        printGiveaway(pay.isGiveaway());
        printAllSale(pay.isSale(), pay.getXmasDDaySale(), isWeekend, pay.getDaySale(), pay.getStarDaySale(), pay.isGiveaway());
        printBenefitPrice(pay.getBenefitPrice());
        printResultPrice(pay.getResultPrice());
        printBadge(pay.getBadge());
    }

    private void printAllPrice(Integer allPrice){
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(moneyFormat(allPrice)+"원");
    }

    private void printGiveaway(boolean giveaway){
        System.out.println("\n<증정 메뉴>");
        if(giveaway){
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    private void printAllSale(boolean sale,Integer xmasDDaySale,boolean isWeekend,Integer daySale,
                             Integer startDaySale,boolean giveaway){
        System.out.println("\n<혜택 내역>");
        if(!sale){
            System.out.println("없음");
            return;
        }
        if(xmasDDaySale>0){
            System.out.println("크리스마스 디데이 할인: -"+moneyFormat(xmasDDaySale)+"원");
        }
        printDaySale(isWeekend,daySale);
        if(startDaySale>0){
            System.out.println("특별 할인 : -"+moneyFormat(startDaySale)+"원");
        }
        if(giveaway){
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    private void printDaySale(boolean isWeekend,Integer daySale){
        if(daySale>0){
            if(isWeekend){
                System.out.print("주말 할인: -");
            }
            if(!isWeekend){
                System.out.print("평일 할인: -");
            }
            System.out.println(moneyFormat(daySale)+"원");
        }
    }

    private void printBenefitPrice(Integer benefitPrice){
        System.out.println("\n<총혜택 금액>");
        if(benefitPrice>0){
            System.out.println("-"+moneyFormat(benefitPrice)+"원");
            return;
        }
        System.out.println("없음");
    }

    private void printResultPrice(Integer resultPrice){
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(moneyFormat(resultPrice)+"원");
    }

    private void printBadge(String badge){
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badge);
    }

    private String moneyFormat(Integer money){
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());

        String formattedMoney = nf.format(money);

        return formattedMoney;
    }

    public void printErrorMessage(Exception error){
        System.out.println(error.getMessage());
    }
}

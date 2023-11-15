package christmas.view;

import christmas.model.Order;
import christmas.model.Pay;


public interface OutputView {

    void start();

    void printDate(Integer date);

    void printMenu(Order order);

    void printPay(Pay pay, boolean isWeekend);

    public void printErrorMessage(Exception error);
}

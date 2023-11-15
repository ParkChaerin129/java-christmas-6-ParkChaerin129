package christmas.controller;

import christmas.model.Day;
import christmas.model.Order;
import christmas.model.Pay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlayEvent {

    GenerateDate generateDate = new GenerateDate();
    GenerateOrder generateOrder = new GenerateOrder();
    GeneratePay generatePay = new GeneratePay();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void playEvent(){
        outputView.start();
        Day day = generateDate.generateDate();
        Order order = generateOrder.generateOrder();
        Pay pay = generatePay.generatePay(order,day);
        outputView.printDate(day.getDate());
        outputView.printMenu(order);
        outputView.printPay(pay, day.isWeekend());
    }

}

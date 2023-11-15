package christmas.controller;

import christmas.model.Day;
import christmas.model.Order;
import christmas.model.Pay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlayEventImpl implements PlayEvent {

    private final GenerateDate generateDate;
    private final GenerateOrder generateOrder;
    private final GeneratePay generatePay;
    private final OutputView outputView;
    private final InputView inputView;

    public PlayEventImpl(GenerateDate generateDate, GenerateOrder generateOrder, GeneratePay generatePay,
                         OutputView outputView, InputView inputView) {
        this.generateDate = generateDate;
        this.generateOrder = generateOrder;
        this.generatePay = generatePay;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void playEvent() {
        outputView.start();
        Day day = generateDate.generateDate();
        Order order = generateOrder.generateOrder();
        Pay pay = generatePay.generatePay(order, day);
        outputView.printDate(day.getDate());
        outputView.printMenu(order);
        outputView.printPay(pay, day.isWeekend());
        inputView.close();
    }

}

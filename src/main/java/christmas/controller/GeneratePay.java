package christmas.controller;

import christmas.model.Day;
import christmas.model.Order;
import christmas.model.Pay;

public interface GeneratePay {

    Pay generatePay(Order order, Day day);
}

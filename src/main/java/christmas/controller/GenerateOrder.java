package christmas.controller;

import christmas.model.Order;

public interface GenerateOrder {

    Order generateOrder();

    Order validOrder(String inputOrder);
}

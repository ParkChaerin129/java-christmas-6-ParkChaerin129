package christmas.controller;

import christmas.model.Day;

public interface GenerateDate {

    Day generateDate();

    Day validDay(String inputDate);
}

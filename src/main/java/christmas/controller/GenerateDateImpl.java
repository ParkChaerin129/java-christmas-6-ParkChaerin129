package christmas.controller;

import christmas.message.ErrorMessage;
import christmas.model.Day;
import christmas.view.InputView;
import christmas.view.OutputView;

public class GenerateDateImpl implements GenerateDate {

    private final InputView inputView;
    private final OutputView outputView;

    public GenerateDateImpl(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Day generateDate() {
        boolean validInput = false;
        Day day;
        do {
            try {
                String inputDate = inputView.readDate();
                day = validDay(inputDate);
                return day;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        } while (!validInput);

        return null;
    }

    public Day validDay(String inputDate) {
        int date;
        try {
            date = Integer.valueOf(inputDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_DAY_INTEGER.toString());
        }
        if (date < 1 | date > 31) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_RANGE.toString());
        }
        return new Day(date);
    }

}

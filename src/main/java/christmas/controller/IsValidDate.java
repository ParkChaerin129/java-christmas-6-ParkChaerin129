package christmas.controller;

import christmas.message.ErrorMessage;
import christmas.model.Day;
import christmas.view.InputView;
import christmas.view.OutputView;

public class IsValidDate {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public Day isValidDate(){
        boolean validInput = false;
        String inputDate = inputView.readDate();
        Day day;
        do{
            try{
                day = generateDay(inputDate);
                return day;
            }catch(IllegalArgumentException e){
                outputView.printErrorMessage(e);
            }
        }while(!validInput);

        return null;
    }

    public Day generateDay(String inputDate){
        int date;
        try {
            date = Integer.valueOf(inputDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_INTEGER.toString());
        }
        if (date < 1 | date > 31) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_RANGE.toString());
        }
        return new Day(date);
    }

}

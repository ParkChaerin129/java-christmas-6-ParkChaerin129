package christmas;

import christmas.controller.*;
import christmas.view.InputView;
import christmas.view.InputViewImpl;
import christmas.view.OutputView;
import christmas.view.OutputViewImpl;

public class AppConfig {

    public InputView inputView(){
        return new InputViewImpl();
    }

    public OutputView outputView(){
        return new OutputViewImpl();
    }

    public GenerateDate generateDate(){
        return new GenerateDateImpl(inputView(),outputView());
    }

    public GenerateOrder generateOrder(){
        return new GenerateOrderImpl(inputView(),outputView());
    }

    public GeneratePay generatePay(){
        return new GeneratePayImpl();
    }

    public PlayEvent playEvent(){
        return new PlayEventImpl(generateDate(),generateOrder(),generatePay(),outputView(),inputView());
    }

}

package christmas.controller;

import christmas.message.ErrorMessage;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class GenerateOrderImpl implements GenerateOrder {

    class MenuInfo {
        String menuName;
        Integer menuAmount;

        MenuInfo(String menuName, Integer menuAmount) {
            this.menuName = menuName;
            this.menuAmount = menuAmount;
        }

    }

    private final InputView inputView;
    private final OutputView outputView;

    public GenerateOrderImpl(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Order generateOrder() {
        boolean validInput = false;
        Order order;
        do {
            try {
                String inputOrder = inputView.readOrder();
                order = validOrder(inputOrder);
                return order;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        } while (!validInput);

        return null;
    }

    public Order validOrder(String inputOrder) {
        String[] menus = inputOrder.split(",");
        Order order = new Order();

        for (String menu : menus) {
            MenuInfo menuInfo = splitMenu(menu);
            order.addOrder(menuInfo.menuName, menuInfo.menuAmount);
        }
        order.isValidOrder();
        return order;
    }

    private MenuInfo splitMenu(String menu) {
        String[] menuInfoSplit = menu.split("-");
        if (menuInfoSplit.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_CORRECT_FORM.toString());
        }
        String menuName = menuInfoSplit[0];
        Integer amount;
        try {
            amount = Integer.parseInt(menuInfoSplit[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_MENU_INTEGER.toString());
        }
        if (amount < 1 | amount > 20) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_MENU_RANGE.toString());
        }
        return new MenuInfo(menuName, amount);
    }

}

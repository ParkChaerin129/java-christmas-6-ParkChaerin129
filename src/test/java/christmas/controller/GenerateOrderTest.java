package christmas.controller;

import christmas.message.ErrorMessage;
import christmas.message.Menu;
import christmas.model.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class GenerateOrderTest {

    GenerateOrder generateOrder = new GenerateOrder();

    @Test
    void 올바른_입력(){
        Order order = generateOrder.validOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Assertions.assertThat(order.getOrder().get(Menu.티본스테이크)).isEqualTo(1);
        Assertions.assertThat(order.getOrder().get(Menu.바비큐립)).isEqualTo(1);
        Assertions.assertThat(order.getOrder().get(Menu.초코케이크)).isEqualTo(2);
        Assertions.assertThat(order.getOrder().get(Menu.제로콜라)).isEqualTo(1);
        Assertions.assertThat(order.getAmountByMenuKind("main")).isEqualTo(2);
        Assertions.assertThat(order.getAmountByMenuKind("dessert")).isEqualTo(2);
        Assertions.assertThat(order.getAmountByMenuKind("drink")).isEqualTo(1);
    }

    @Test
    void 음료만_입력(){
        Assertions.assertThatThrownBy(() -> generateOrder.validOrder("제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_ONLY_DRINK.toString());

    }

    @Test
    void 형식에_맞지_않는_입력(){
        Assertions.assertThatThrownBy(() -> generateOrder.validOrder("제로콜라"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_CORRECT_FORM.toString());
        Assertions.assertThatThrownBy(() -> generateOrder.validOrder(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_CORRECT_FORM.toString());
    }

    @Test
    void 메뉴의_총_합이_20이_넘는_입력(){
        Assertions.assertThatThrownBy(() -> generateOrder.validOrder("티본스테이크-10,바비큐립-1,초코케이크-10,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_MENU_RANGE.toString());
    }



}

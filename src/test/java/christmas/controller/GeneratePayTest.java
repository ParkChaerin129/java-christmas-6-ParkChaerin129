package christmas.controller;

import christmas.AppConfig;
import christmas.model.Day;
import christmas.model.Order;
import christmas.model.Pay;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratePayTest {

    AppConfig appConfig = new AppConfig();
    GenerateDate generateDate = appConfig.generateDate();
    GenerateOrder generateOrder = appConfig.generateOrder();


    GeneratePay generatePay = appConfig.generatePay();

    @Test
    void 올바른_계산(){
        Day day = generateDate.validDay("3");
        Order order = generateOrder.validOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Pay pay =generatePay.generatePay(order,day);
        Assertions.assertThat(pay.getAllPrice()).isEqualTo(142000);
        Assertions.assertThat(pay.isGiveaway()).isTrue();
        Assertions.assertThat(pay.getXmasDDaySale()).isEqualTo(1200);
        Assertions.assertThat(pay.getDaySale()).isEqualTo(4046);
        Assertions.assertThat(pay.getStarDaySale()).isEqualTo(1000);
        Assertions.assertThat(pay.getBenefitPrice()).isEqualTo(31246);
        Assertions.assertThat(pay.getResultPrice()).isEqualTo(135754);
        Assertions.assertThat(pay.getBadge()).isEqualTo("산타");
        Assertions.assertThat(pay.isSale()).isTrue();
    }

    @Test
    void 올바른_혜택_없는_계산(){
        Day day = generateDate.validDay("26");
        Order order = generateOrder.validOrder("타파스-1,제로콜라-1");
        Pay pay =generatePay.generatePay(order,day);
        Assertions.assertThat(pay.isSale()).isFalse();
        Assertions.assertThat(pay.getBenefitPrice()).isEqualTo(0);
    }
}

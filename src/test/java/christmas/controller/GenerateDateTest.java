package christmas.controller;

import christmas.AppConfig;
import christmas.message.ErrorMessage;
import christmas.model.Day;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class GenerateDateTest {

    AppConfig appConfig = new AppConfig();
    GenerateDate generateDate = appConfig.generateDate();

    @Test
    void 올바른_입력(){
        Day day = generateDate.validDay("21");
        Assertions.assertThat(day.getDate()).isEqualTo(21);
        Assertions.assertThat(day.isStarDay()).isFalse();
        Assertions.assertThat(day.isWeekend()).isFalse();

        Day day2 = generateDate.validDay("25");
        Assertions.assertThat(day2.getDate()).isEqualTo(25);
        Assertions.assertThat(day2.isStarDay()).isTrue();
        Assertions.assertThat(day2.isWeekend()).isFalse();

        Day day3 = generateDate.validDay("23");
        Assertions.assertThat(day3.getDate()).isEqualTo(23);
        Assertions.assertThat(day3.isStarDay()).isFalse();
        Assertions.assertThat(day3.isWeekend()).isTrue();

        Day day4 = generateDate.validDay("1");
        Assertions.assertThat(day4.getDate()).isEqualTo(1);
        Assertions.assertThat(day4.isStarDay()).isFalse();
        Assertions.assertThat(day4.isWeekend()).isTrue();
    }

    @Test
    void 정수가_아닌_입력(){
        Assertions.assertThatThrownBy(()-> generateDate.validDay("테스트"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_DAY_INTEGER.toString());

        Assertions.assertThatThrownBy(()-> generateDate.validDay("1.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_DAY_INTEGER.toString());
    }

    @Test
    void 범위가_아닌_입력(){
        Assertions.assertThatThrownBy(()-> generateDate.validDay("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_RANGE.toString());

        Assertions.assertThatThrownBy(()-> generateDate.validDay("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_RANGE.toString());

        Assertions.assertThatThrownBy(()-> generateDate.validDay("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_RANGE.toString());
    }

}

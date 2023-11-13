package christmas.controller;

import christmas.message.ErrorMessage;
import christmas.model.Day;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class IsValidDateTest {

    IsValidDate isValidDate = new IsValidDate();

    @Test
    void 올바른_입력(){
        Day day = isValidDate.generateDay("21");
        Assertions.assertThat(day.getDate()).isEqualTo(21);
        Assertions.assertThat(day.isStarDay()).isFalse();
        Assertions.assertThat(day.isWeekend()).isFalse();

        Day day2 = isValidDate.generateDay("25");
        Assertions.assertThat(day2.getDate()).isEqualTo(25);
        Assertions.assertThat(day2.isStarDay()).isTrue();
        Assertions.assertThat(day2.isWeekend()).isFalse();

        Day day3 = isValidDate.generateDay("23");
        Assertions.assertThat(day3.getDate()).isEqualTo(23);
        Assertions.assertThat(day3.isStarDay()).isFalse();
        Assertions.assertThat(day3.isWeekend()).isTrue();
    }

    @Test
    void 정수가_아닌_입력(){
        Assertions.assertThatThrownBy(()-> isValidDate.generateDay("테스트"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_INTEGER.toString());

        Assertions.assertThatThrownBy(()-> isValidDate.generateDay("1.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_INTEGER.toString());
    }

    @Test
    void 범위가_아닌_입력(){
        Assertions.assertThatThrownBy(()-> isValidDate.generateDay("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_RANGE.toString());

        Assertions.assertThatThrownBy(()-> isValidDate.generateDay("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_RANGE.toString());

        Assertions.assertThatThrownBy(()-> isValidDate.generateDay("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_RANGE.toString());
    }

}

package calculator;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputParserTest {

    InputParser inputParser = new InputParser();

    static final String INPUT_WITHOUT_DELIMITER1 = "1,2,3,4";
    static final String INPUT_WITHOUT_DELIMITER2 = "1:2:3:4";
    static final String INPUT_WITHOUT_DELIMITER3 = "1,2:3,4";
    static final String INPUT_WITHOUT_DELIMITER4 = "1:2,3:4";

    @Test
    void 기본_입력() {
        //given, when
        List<Long> numberList1 = inputParser.parse(INPUT_WITHOUT_DELIMITER1);
        List<Long> numberList2 = inputParser.parse(INPUT_WITHOUT_DELIMITER2);
        List<Long> numberList3 = inputParser.parse(INPUT_WITHOUT_DELIMITER3);
        List<Long> numberList4 = inputParser.parse(INPUT_WITHOUT_DELIMITER4);

        //then
        Assertions.assertThat(numberList1).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));
        Assertions.assertThat(numberList2).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));
        Assertions.assertThat(numberList3).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));
        Assertions.assertThat(numberList4).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));
    }

    static final String WRONG_INPUT_WITHOUT_DELIMITER1 = "1,2^3,4";
    static final String WRONG_INPUT_WITHOUT_DELIMITER2 = "1^2^3^4";
    static final String WRONG_INPUT_WITHOUT_DELIMITER3 = "a,2,3,4";
    static final String WRONG_INPUT_WITHOUT_DELIMITER4 = "-1:2,3:4";

    @Test
    void 기본_입력_예외() {

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITHOUT_DELIMITER1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LETTER_ERROR);

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITHOUT_DELIMITER2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LETTER_ERROR);

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITHOUT_DELIMITER3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LETTER_ERROR);

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITHOUT_DELIMITER4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_NUMBER_ERROR);
    }

    static final String INPUT_WITH_DELIMITER1 = "//;\n1;2;3;4";
    static final String INPUT_WITH_DELIMITER2 = "//;\n1;2,3:4";
    static final String INPUT_WITH_DELIMITER3 = "//;^\n1;2^3:4";
    static final String INPUT_WITH_DELIMITER4 = "//;^\n1;2^3,4";

    @Test
    void 커스텀_구분자_입력() {

        //given, when
        List<Long> numberList1 = inputParser.parse(INPUT_WITH_DELIMITER1);
        List<Long> numberList2 = inputParser.parse(INPUT_WITH_DELIMITER2);
        List<Long> numberList3 = inputParser.parse(INPUT_WITH_DELIMITER3);
        List<Long> numberList4 = inputParser.parse(INPUT_WITH_DELIMITER4);

        //then
        Assertions.assertThat(numberList1).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));
        Assertions.assertThat(numberList2).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));
        Assertions.assertThat(numberList3).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));
        Assertions.assertThat(numberList4).isEqualTo(Arrays.asList(1L, 2L, 3L, 4L));

    }

    static final String WRONG_INPUT_WITH_DELIMITER1 = "//;\n1^2^3^4";
    static final String WRONG_INPUT_WITH_DELIMITER2 = "//;\n1;2&3^4";
    static final String WRONG_INPUT_WITH_DELIMITER3 = "//;^\na;2;3;4";
    static final String WRONG_INPUT_WITH_DELIMITER4 = "//;^\n-1;2;3;4";

    @Test
    void 커스텀_구분자_입력_예외() {

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITH_DELIMITER1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LETTER_ERROR);

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITH_DELIMITER2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LETTER_ERROR);

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITH_DELIMITER3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LETTER_ERROR);

        Assertions.assertThatThrownBy(() -> inputParser.parse(WRONG_INPUT_WITH_DELIMITER4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_NUMBER_ERROR);
    }
}
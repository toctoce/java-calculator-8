package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
            run(InputData.INPUT_WITH_DELIMITER1);
            assertThat(output()).contains("결과 : 10");
            run(InputData.INPUT_WITH_DELIMITER2);
            assertThat(output()).contains("결과 : 10");
            run(InputData.INPUT_WITH_DELIMITER3);
            assertThat(output()).contains("결과 : 10");
            run(InputData.INPUT_WITH_DELIMITER4);
            assertThat(output()).contains("결과 : 10");
            run(InputData.INPUT_WITH_DELIMITER5);
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_입력() {
        assertSimpleTest(() -> {
            run(InputData.INPUT_WITHOUT_DELIMITER1);
            assertThat(output()).contains("결과 : 10");
            run(InputData.INPUT_WITHOUT_DELIMITER2);
            assertThat(output()).contains("결과 : 10");
            run(InputData.INPUT_WITHOUT_DELIMITER3);
            assertThat(output()).contains("결과 : 10");
            run(InputData.INPUT_WITHOUT_DELIMITER4);
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_사용_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITH_DELIMITER1))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITH_DELIMITER2))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITH_DELIMITER3))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITH_DELIMITER4))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITHOUT_DELIMITER1))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITHOUT_DELIMITER2))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITHOUT_DELIMITER3))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(InputData.WRONG_INPUT_WITHOUT_DELIMITER4))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

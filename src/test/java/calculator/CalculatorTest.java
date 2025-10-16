package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void 덧셈연산() {
        //given
        ArrayList<Long> nums1 = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        ArrayList<Long> nums2 = new ArrayList<>(Arrays.asList(100L, 200L, 300L, 400L, 500L));
        ArrayList<Long> nums3 = new ArrayList<>(Arrays.asList(1_000_000_000_000L, 2_000_000_000_000L));

        //when
        Long result1 = calculator.add(nums1);
        Long result2 = calculator.add(nums2);
        Long result3 = calculator.add(nums3);

        //then
        assertThat(result1).isEqualTo(6L);
        assertThat(result2).isEqualTo(1500L);
        assertThat(result3).isEqualTo(3_000_000_000_000L);
    }

}
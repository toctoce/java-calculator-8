package calculator;

import java.util.ArrayList;

public class Calculator {

    public Long add(ArrayList<Long> nums) {
        Long sum = 0L;
        for (Long num : nums) {
            sum += num;
        }
        return sum;
    }
}

package calculator;

import java.util.List;

public class Calculator {

    public Long add(List<Long> numberList) {
        Long sum = 0L;
        for (Long num : numberList) {
            sum += num;
        }
        return sum;
    }
}

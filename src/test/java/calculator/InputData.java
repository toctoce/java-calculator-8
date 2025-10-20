package calculator;

public final class InputData {
    private InputData() {
        throw new AssertionError("인스턴스를 만들 수 없습니다.");
    }

    static final String INPUT_WITHOUT_DELIMITER1 = "1,2,3,4";
    static final String INPUT_WITHOUT_DELIMITER2 = "1:2:3:4";
    static final String INPUT_WITHOUT_DELIMITER3 = "1,2:3,4";
    static final String INPUT_WITHOUT_DELIMITER4 = "1:2,3:4";

    static final String WRONG_INPUT_WITHOUT_DELIMITER1 = "1,2^3,4";
    static final String WRONG_INPUT_WITHOUT_DELIMITER2 = "1^2^3^4";
    static final String WRONG_INPUT_WITHOUT_DELIMITER3 = "a,2,3,4";
    static final String WRONG_INPUT_WITHOUT_DELIMITER4 = "-1:2,3:4";

    static final String INPUT_WITH_DELIMITER1 = "//;\\n1;2;3;4";
    static final String INPUT_WITH_DELIMITER2 = "//;\\n1;2,3:4";
    static final String INPUT_WITH_DELIMITER3 = "//;^\\n1;2^3:4";
    static final String INPUT_WITH_DELIMITER4 = "//;^\\n1;2^3,4";
    static final String INPUT_WITH_DELIMITER5 = "//;\\n1";

    static final String WRONG_INPUT_WITH_DELIMITER1 = "//;\\n1^2^3^4";
    static final String WRONG_INPUT_WITH_DELIMITER2 = "//;\\n1;2&3^4";
    static final String WRONG_INPUT_WITH_DELIMITER3 = "//;^\\na;2;3;4";
    static final String WRONG_INPUT_WITH_DELIMITER4 = "//;^\\n-1;2;3;4";
}

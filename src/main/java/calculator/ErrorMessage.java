package calculator;

public final class ErrorMessage {

    private ErrorMessage() {
        throw new AssertionError("인스턴스를 만들 수 없습니다.");
    }

    public static final String INVALID_LETTER_ERROR =
            "잘못된 문자가 입력되었습니다.";

    public static final String NEGATIVE_NUMBER_ERROR =
            "양이 아닌 정수가 입력되었습니다.";
}
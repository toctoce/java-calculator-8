package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력 문자열을 유효한 데이터로 변환
 */
public class InputParser {

    private static final String DEFAULT_DELIMITER = ",:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.+)\\\\n(.*)$");

    private record SeparatedParts(String delimiterPart, String numberPart) {
    }

    public List<Long> parse(String input) {

        if (input == null || input.isEmpty()) {
            return List.of();
        }

        SeparatedParts separatedParts = separateParts(input);

        String delimiterRegex = extractDelimiter(separatedParts.delimiterPart);

        List<Long> numberList = extractNumber(separatedParts.numberPart, delimiterRegex);

        validateNumberList(numberList);

        return numberList;
    }

    /**
     * 정수 부분 문자열에서 정수를 추출
     *
     * @param numberPart     정수 부분 문자열
     * @param delimiterRegex 구분자 정규표현식
     * @return 추출된 정수 리스트
     */
    private List<Long> extractNumber(String numberPart, String delimiterRegex) {

        String[] numberStringArray = numberPart.split(delimiterRegex);

        List<Long> numberList = new ArrayList<>();
        for (String number : numberStringArray) {
            try {
                numberList.add(Long.parseLong(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LETTER_ERROR);
            }
        }

        return numberList;
    }

    /**
     * 구분자 부분 문자열에서 구분자를 추출해 정규표현식 생성
     *
     * @param delimiterPart 구분자 부분 문자열
     * @return 구분자 정규표현식
     */
    private String extractDelimiter(String delimiterPart) {

        if (delimiterPart != null) {
            return "[" + DEFAULT_DELIMITER + delimiterPart + "]";
        }
        return "[" + DEFAULT_DELIMITER + "]";
    }

    /**
     * 사용자 입력을 구분자 부분과 정수 부분으로 분리 구분자가 없다면 null
     *
     * @param input 사용자 입력
     * @return 구분자 부분, 정수 부분
     */
    private SeparatedParts separateParts(String input) {

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            String delimiterPart = matcher.group(1);
            String numberPart = matcher.group(2);

            return new SeparatedParts(delimiterPart, numberPart);
        }

        return new SeparatedParts(null, input);

    }

    /**
     * 양의 정수인지 검사, 올바르지 않을 시 에러
     *
     * @param numberList 검사할 정수 리스트
     */
    private void validateNumberList(List<Long> numberList) {
        for (Long number : numberList) {
            if (number <= 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_ERROR);
            }
        }
    }
}

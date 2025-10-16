package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력 처리
 */
public class InputReader {

    public String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        return Console.readLine();
    }
}

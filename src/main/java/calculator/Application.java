package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        Calculator calculator = new Calculator();
        OutputWriter outputWriter = new OutputWriter();
        InputParser inputParser = new InputParser();

        String input = inputReader.read();
        List<Long> numberList = inputParser.parse(input);
        Long addResult = calculator.add(numberList);
        outputWriter.writeResult(addResult);
    }
}

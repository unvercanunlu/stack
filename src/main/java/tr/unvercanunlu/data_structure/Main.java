package tr.unvercanunlu.data_structure;

import tr.unvercanunlu.data_structure.stack.impl.exception.NegativeCapacity;
import tr.unvercanunlu.data_structure.stack.impl.exception.StackOverflow;
import tr.unvercanunlu.data_structure.stack.impl.exception.StackUnderflow;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static tr.unvercanunlu.data_structure.Examples.checkParentheses;
import static tr.unvercanunlu.data_structure.Examples.reverseText;

public class Main {

    private static final Supplier<String> generateLineBreak = () ->
            IntStream.range(0, 100).mapToObj(i -> "*").collect(Collectors.joining());

    private static final BiFunction<Object, Object, String> compare =
            (actual, expected) -> (((actual == null) && (expected == null))
                    || ((actual != null) && actual.equals(expected))) ? "SUCCESS" : "FAIL";

    private static void runTest(String name, Map<Object, Object> cases, UnaryOperator<Object> method) {
        for (Map.Entry<Object, Object> testCase : cases.entrySet()) {
            Object input = testCase.getKey();
            Object expected = testCase.getValue();
            Object actual = method.apply(input);
            String result = compare.apply(actual, expected);
            System.out.println(name + " of '" + input + "': '" + actual
                    + "' , expected: '" + expected + "' , result: " + result);
        }
    }

    private static void runTestForCheckParentheses() {
        Map<Object, Object> cases = new HashMap<>();
        cases.put(null, false);
        cases.put("", true);
        cases.put("abc", true);
        cases.put("ab(", false);
        cases.put("ab)", false);
        cases.put("(ab)", true);
        cases.put("(ab<)", false);
        cases.put("{(ab<c>)}", true);

        runTest("check parentheses", cases, expression -> {
            Boolean output = null;

            String input = (expression != null) ? expression.toString() : null;

            try {
                output = checkParentheses(input);
            } catch (StackOverflow | NegativeCapacity | StackUnderflow e) {
                e.printStackTrace();
            }

            return output;
        });
    }

    private static void runTestForReverseText() {
        Map<Object, Object> cases = new HashMap<>();
        cases.put(null, null);
        cases.put("", "");
        cases.put("abc", "cba");
        cases.put("abcd", "dcba");

        runTest("reverse text", cases, text -> {
            String output = null;

            String input = (text != null) ? text.toString() : null;

            try {
                output = reverseText(input);
            } catch (StackOverflow | NegativeCapacity | StackUnderflow e) {
                e.printStackTrace();
            }

            return output;
        });
    }

    public static void main(String[] args) {
        String lineBreak = generateLineBreak.get();

        System.out.println(lineBreak);

        runTestForCheckParentheses();

        System.out.println(lineBreak);

        runTestForReverseText();

        System.out.println(lineBreak);
    }
}

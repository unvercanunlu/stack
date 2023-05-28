package tr.unvercanunlu.data_structure;

import tr.unvercanunlu.stack.impl.Stack;
import tr.unvercanunlu.stack.impl.exception.NegativeCapacity;
import tr.unvercanunlu.stack.impl.exception.StackOverflow;
import tr.unvercanunlu.stack.impl.exception.StackUnderflow;

import java.util.function.Predicate;

public class Examples {

    public static boolean checkParentheses(String expression) throws NegativeCapacity, StackOverflow, StackUnderflow {
        if (expression == null) return false;

        Predicate<Character> checkOpening = character -> (character != null) && ((character == '(')
                || (character == '[') || (character == '{') || (character == '<'));

        Predicate<Character> checkClosing = character -> (character != null) && ((character == ')')
                || (character == ']') || (character == '}') || (character == '>'));

        Stack<Character> parenthesesStack = new Stack<>(expression.length());

        char[] characters = expression.toCharArray();

        boolean result = true;

        for (Character character : characters) {
            if (checkOpening.test(character)) {
                parenthesesStack.push(character);
            } else if (checkClosing.test(character) && (parenthesesStack.isEmpty() || (parenthesesStack.peek() == null)
                    || ((character == ')') && (parenthesesStack.pop() != '('))
                    || ((character == ']') && (parenthesesStack.pop() != '['))
                    || ((character == '}') && (parenthesesStack.pop() != '{'))
                    || ((character == '>') && (parenthesesStack.pop() != '<')))) {
                result = false;
                break;
            }
        }

        if (!parenthesesStack.isEmpty()) {
            result = false;
        }

        return result;
    }

    public static String reverseText(String text) throws StackOverflow, NegativeCapacity, StackUnderflow {
        if (text == null) return null;

        Stack<Character> characterStack = new Stack<>(text.length());

        char[] characters = text.toCharArray();

        for (Character character : characters) {
            characterStack.push(character);
        }

        StringBuilder builder = new StringBuilder();

        while (!characterStack.isEmpty()) {
            Character character = characterStack.pop();

            builder.append(character);
        }

        return builder.toString();
    }
}

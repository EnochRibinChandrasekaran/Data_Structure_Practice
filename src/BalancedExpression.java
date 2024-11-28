import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {
    public static final List<Character> CLOSING_BRACKETS = Arrays.asList(')', '>', ']', '}');
    public static final List<Character> OPENING_BRACKETS = Arrays.asList('(', '<', '[', '{');

    public static void main(String[] args) {
        String item = "(((<>)))";
        System.out.println("Balanced Exp : "+ BalancedBrackets(item));
    }

    public static boolean BalancedBrackets(String exp){
        Stack<Character> stack = new Stack<>();
        for(char ch: exp.toCharArray()){
            if(isOpenBracket(ch)){
                stack.push(ch);
            }
            if(isCloseBracket(ch)) {

                if (stack.isEmpty())
                    return false;

                var top = stack.pop();
                if(isBracketMatch(ch, top))
                    return false;

                }
            }

        return stack.isEmpty();
    }

    private static boolean isBracketMatch(char ch, Character top) {
        return CLOSING_BRACKETS.indexOf(ch)== OPENING_BRACKETS.indexOf(top);
    }

    private static boolean isCloseBracket(char ch) {
        return CLOSING_BRACKETS.contains(ch);
    }

    private static boolean isOpenBracket(char ch) {
        return OPENING_BRACKETS.contains(ch);
    }
}

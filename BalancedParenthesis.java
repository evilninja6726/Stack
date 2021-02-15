package stackDs;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        System.out.println(isBalancedParenthesis("(){{}}{[()]}"));
    }

    public static boolean isBalancedParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                if (!isMatching(stack.peek(), s.charAt(i)))
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static boolean isMatching(char a, char b) {
        if ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'))
            return true;
        return false;
    }
}

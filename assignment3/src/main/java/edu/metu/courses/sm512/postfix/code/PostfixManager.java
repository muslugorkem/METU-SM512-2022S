package edu.metu.courses.sm512.postfix.code;

import java.util.ArrayList;
import java.util.Stack;

import edu.metu.courses.sm512.postfix.common.PostfixADT;
import edu.metu.courses.sm512.postfix.common.Token;

/**
 * @author Gorkem Muslu 1932524
 */
public class PostfixManager implements PostfixADT {

    @Override
    public Token[] convertInfixToPostfix(Token[] infix) {

        Stack<Token> stack = new Stack<>();
        ArrayList<Token> postfix = new ArrayList<>();

        for (Token token : infix) {
            if (token.isNumber()) {
                // numbers should be directly added
                postfix.add(token);
            } else if (isOperator(token.getOperator())) {
                // if the token is an operator, pop all operators with higher precedence
                while (!stack.empty() && isOperator(stack.peek().getOperator())
                    && getPrecedence(stack.peek().getOperator()) >= getPrecedence(token.getOperator())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            } else if (token.getOperator() == '(') {
                stack.push(token);
            } else if (token.getOperator() == ')') {
                // if the token is a closing parenthesis, pop all operators until the opening parenthesis
                while (!stack.empty() && stack.peek().getOperator() != '(') {
                    postfix.add(stack.pop());
                }
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }
        // Pop until stack is empty to make sure all operators are added to the postfix expression
        while (!stack.empty()) {
            postfix.add(stack.pop());
        }

        return postfix.toArray(new Token[postfix.size()]);
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // We should use this method to obtain the precedence of multiplication and division over addition and subtraction
    private int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    @Override
    public int evaluatePostfix(Token[] postfix) {
        Stack<Integer> stack = new Stack<>();

        for (Token token : postfix) {
            if (token.isNumber()) {
                stack.push(token.getNumber());
            } else {
                int rhs = stack.pop(); // Right hand side should be popped first
                int lhs = stack.pop();
                char operator = token.getOperator();

                // Push the result back to the stack
                switch (operator) {
                    case '+':
                        stack.push(lhs + rhs);
                        break;
                    case '-':
                        stack.push(lhs - rhs);
                        break;
                    case '*':
                        stack.push(lhs * rhs);
                        break;
                    case '/':
                        if (rhs == 0) {
                            throw new RuntimeException("Error: Division by zero");
                        }
                        stack.push(lhs / rhs);
                        break;
                }
            }
        }

        // if the size of the stack is not 1, the postfix expression is invalid
        if (stack.size() != 1) {
            throw new RuntimeException("Error: Invalid postfix");
        }
        return stack.pop();
    }

}

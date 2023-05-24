package edu.metu.courses.sm512.postfix;

import java.util.Scanner;
import edu.metu.courses.sm512.postfix.common.*;
import edu.metu.courses.sm512.postfix.code.PostfixManager;

public class PostfixApp {

    public static final String WELCOME_MESSAGE
            = "Enter an infix expression to convert to postfix and evaluate.\n"
            + "For example enter `12*(3+8)+2*24` \n"
            + "Enter 'q' to quit.";

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String line = "";
        PostfixADT pfman = new PostfixManager();
        while (!"q".equalsIgnoreCase(line)) {
            if (!"".equals(line)) {
                try {
                    Token[] infixTokens = Token.getTokens(line);
                    System.out.print("Tokens:");
                    for (Token t : infixTokens) {
                        System.out.print(" " + t);
                    }
                    System.out.println();
                    Token[] postfixTokens = pfman.convertInfixToPostfix(infixTokens);
                    System.out.print("Postfix:");
                    for (Token t : postfixTokens) {
                        System.out.print(" " + t);
                    }
                    System.out.println();
                    int value = pfman.evaluatePostfix(postfixTokens);
                    System.out.println("Result:" + value);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Expression:");
            line = scanner.nextLine();
        }
    }

}

package edu.metu.courses.sm512.postfix.common;

public interface PostfixADT {

    Token[] convertInfixToPostfix(Token[] infix);

    int evaluatePostfix(Token[] postfix);
}

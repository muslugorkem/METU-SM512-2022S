package edu.metu.courses.sm512.postfix.common;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token {

    public static final Pattern TOKEN_PATTERN = Pattern.compile("\\s*([()+*-/]|[0-9]+)\\s*");
    private static final char NUMBER_TOKEN = '#';

    public static Token[] getTokens(String expression) {
        ArrayList<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(expression);
        int start = 0;
        while (matcher.find(start)) {
            if (matcher.start() != start) {
                throw new RuntimeException("Pattern mismatch");
            }
            for (int i = 1; matcher.groupCount() >= i; i++) {
                tokens.add(new Token(matcher.group(i)));
            }
            start = matcher.end();
        }
        return tokens.toArray(Token[]::new);
    }

    private char operator = NUMBER_TOKEN;
    private int number = 0;

    public Token(int number) {
        this.number = number;
    }

    public Token(String text) {
        if (text == null || text.length() < 1) {
            throw new IllegalArgumentException("Non-empty string expected");
        }
        char ch = text.charAt(text.length() - 1);
        if (Character.isDigit(ch)) {
            number = Integer.parseInt(text);
        } else {
            if (ch == NUMBER_TOKEN) {
                throw new IllegalArgumentException("This value is reserved for number token");
            }
            operator = ch;
        }
    }

    public boolean isNumber() {
        return operator == NUMBER_TOKEN;
    }

    public int getNumber() {
        if (operator == NUMBER_TOKEN) {
            return number;
        }
        throw new RuntimeException("This token is not a number");
    }

    public char getOperator() {
        if (operator == NUMBER_TOKEN) {
            throw new RuntimeException("This token is a number");
        }
        return operator;
    }

    @Override
    public String toString() {
        return this.isNumber() ? Integer.toString(number) : Character.toString(operator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token other = (Token) obj;
        return this.operator == other.operator && this.number == other.number;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.operator;
        hash = 47 * hash + this.number;
        return hash;
    }

}

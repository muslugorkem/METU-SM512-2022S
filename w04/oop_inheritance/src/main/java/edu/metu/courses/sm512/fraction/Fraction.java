/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.fraction;

/**
 * This is an immutable Fraction object
 *
 * @author Serkan
 */
public class Fraction extends Object {

    /**
     * Returns the greatest common divisor of the parameters m and n
     *
     * @param m the first number
     * @param n the second number
     *
     * @return the greatest common divisor of m and n
     */
    public static int gcd(int m, int n) {
        //the code implementing the Euclidean algorithm
        int r = n % m;
        while (r != 0) {
            n = m;
            m = r;
            r = n % m;
        }
        return m;
    }

    private final int numerator;
    private final int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public int hashCode() {
        Double d = this.doubleValue();
        return d.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        return this.doubleValue() == other.doubleValue();
    }

    @Override
    public String toString() {
        return "Fraction(" + numerator + "/" + denominator + ')';
    }

    public Fraction simplify() {
        int gcd = Fraction.gcd(numerator, denominator);
        int n = numerator / gcd;
        int d = denominator / gcd;
        Fraction s = new Fraction(n, d);
        return s;
    }

    public double doubleValue() {
        return (double) numerator / denominator;
    }

}

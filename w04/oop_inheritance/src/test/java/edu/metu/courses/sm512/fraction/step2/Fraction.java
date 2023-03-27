/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.fraction.step2;

import edu.metu.courses.sm512.fraction.step1.*;

/**
 *
 * @author Serkan
 */
public class Fraction {

    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction(int num, int denom) {
        this.numerator = num;
        this.denominator = denom;
    }

    @Override
    public String toString() {
        return "Frac:(" + numerator + "/" + denominator + ')';
    }
}

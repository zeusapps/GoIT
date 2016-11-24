package com.example.andrew.fraction;

import java.security.InvalidParameterException;

/**
 * Created by Andrew on 24.11.2016.
 */

public class Fraction {

    private int _numerator;
    private int _denominator;


    public Fraction(int numerator, int denominator){
        _numerator = numerator;
        _denominator = denominator;

        simplify();
    }

    public int getDenominator() {
        return _denominator;
    }

    public int getNumerator() {
        return _numerator;
    }

    public Fraction add(Fraction fraction){
        if (fraction._denominator == _denominator){
            return new Fraction(_numerator + fraction._numerator, _denominator);
        }

        return new Fraction(
            _numerator * fraction._denominator + fraction._numerator * _denominator,
            _denominator * fraction._denominator
        );
    }

    public Fraction subtract(Fraction fraction){
        return add(new Fraction(-fraction._numerator, fraction._denominator));
    }

    public Fraction multiply(Fraction fraction){
        return new Fraction(
                _numerator * fraction._numerator,
                _denominator * fraction._denominator);
    }

    public Fraction divide(Fraction fraction){
        return new Fraction(
                _numerator * fraction._denominator,
                _denominator * fraction._numerator);
    }

    public static Fraction Calculate(Fraction f1, Fraction f2, FractionOperations operation){
        switch (operation){
            case ADD:
                return f1.add(f2);
            case SUBTRACT:
                return f1.subtract(f2);
            case MULTIPLY:
                return f1.multiply(f2);
            case DIVIDE:
                return f1.divide(f2);
            default:
                throw new InvalidParameterException("Operation");
        }
    }

    @Override
    public String toString() {
        if (_numerator == 0){
            return "0";
        }
        if (_denominator == 0){
            return "NaN";
        }

        if (_denominator == 1){
            return "" + _numerator;
        }

        return _numerator + "/" + _denominator;
    }

    public static Fraction Parse(String string){
        String[] parts = string.split("/");

        if (parts.length > 2){
            throw new InvalidParameterException("fraction");
        }

        int numerator = Integer.parseInt(parts[0]);
        int denominator = parts.length == 2
                ? Integer.parseInt(parts[1])
                : 1;

        return new Fraction(
                numerator,
                denominator
        );
    }

    void simplify()
    {
        int gcd = findGCD(_numerator, _denominator);
        _numerator /= gcd;
        _denominator /= gcd;
    }


    //GCD Function
    int findGCD(int a, int b)
    { int temp;
        while(b != 0)
        {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

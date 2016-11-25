package com.example.eugen.hyperbola;

/**
 * Created by Eugen on 25.11.2016.
 */

public class Hyperbola {
    private double _x;
    private double _y;

    public Hyperbola(double x, double y){
        _x = x;
        _y = y;
    }

    public static Hyperbola calculateX(int y){
        return new Hyperbola(Math.sqrt(y), y);
    }

    public static Hyperbola calculateY(int x){
        return new Hyperbola(x, Math.pow(x,2));
    }

    @Override
    public String toString() {
        return "Hyperbola{" +
                "x=" + _x +
                ", y=" + _y +
                '}';
    }
}

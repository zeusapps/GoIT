package com.example.eugen.hyperbola;

/**
 * Created by Eugen on 23.11.2016.
 */

public class HyperbolaService {
    public Double calculateY(double x){
        return Math.pow(x, 2);
    }

    public Double calculateX(double y){
        return Math.sqrt(y);
    }
}

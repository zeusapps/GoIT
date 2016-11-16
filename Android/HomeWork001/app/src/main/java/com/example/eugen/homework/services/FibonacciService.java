package com.example.eugen.homework.services;

/**
 * Created by Eugen on 16.11.2016.
 */

public final class FibonacciService implements IFibonacciService {

    private static FibonacciService _instance;

    private FibonacciService(){

    }

    @Override
    public int calculate(int position) {
        if (position < 0){
            return -1;
        }

        int lo = 0;
        int hi = 1;
        for (int i = 0; i < position; i++) {
            hi = lo + hi;
            lo = hi - lo;
        }
        return lo;

    }

    public static IFibonacciService instance(){
        if (_instance == null){
            _instance = new FibonacciService();
        }

        return _instance;
    }
}

package com.example.eugen.test.models;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static String ID_EXTRA = "id";

    private int _id;

    private String _name;

    private ArrayList<TestItem> _testItems;

    public Test(String testName){
        _name = testName;
        _testItems = new ArrayList<>();


        _id = (new Random()).nextInt();
    }

    public String getName() {
        return _name;
    }

    public int getId() {
        return _id;
    }

    public ArrayList<TestItem> getTestItems() {
        return _testItems;
    }
}

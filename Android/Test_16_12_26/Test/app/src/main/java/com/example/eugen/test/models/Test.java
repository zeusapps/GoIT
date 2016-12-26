package com.example.eugen.test.models;

import java.util.ArrayList;

public class Test {
    private String _name;

    private ArrayList<TestItem> _testItems;

    public Test(String testName){
        _name = testName;
        _testItems = new ArrayList<>();
    }

    public String getName() {
        return _name;
    }

    public ArrayList<TestItem> getTestItems() {
        return _testItems;
    }
}

package com.example.eugen.test.repositories;

import com.example.eugen.test.models.Test;

import java.util.ArrayList;

public class TestsRepository {

    private ArrayList<Test> _tests;

    public TestsRepository(){
        _tests = new ArrayList<>();
    }

    public ArrayList<Test> getTests() {
        return _tests;
    }

    public void addTest(Test test){
        _tests.add(test);
    }

    public Test getTest(int id){
        for (Test test: _tests){
            if (test.getId() == id){
                return test;
            }
        }
        return null;
    }
}

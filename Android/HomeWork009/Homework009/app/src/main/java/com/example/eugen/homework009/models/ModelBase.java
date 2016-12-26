package com.example.eugen.homework009.models;

public abstract class ModelBase {
    private int _number;

    public ModelBase(int number){
        _number = number;
    }

    public String getTitle() {
        return this.getClass().getSimpleName() + " " + _number;
    }

    public int getNumber(){
        return _number;
    }
}

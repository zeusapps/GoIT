package com.example.eugen.homework009.models;

public abstract class ModelBase {
    private String _title;

    public ModelBase(String title){
        _title = title;
    }

    public String getTitle() {
        return _title;
    }
}

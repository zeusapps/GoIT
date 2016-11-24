package com.example.andrew.strings;

/**
 * Created by Andrew on 24.11.2016.
 */

public class ArgumentCheckResult {

    private String _type;
    private String _value;

    public ArgumentCheckResult(
            String type, String value){
        _type = type;
        _value = value;
    }

    public String getType() {
        return _type;
    }

    public String getValue() {
        return _value;
    }

}

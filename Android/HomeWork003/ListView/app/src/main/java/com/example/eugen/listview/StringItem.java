package com.example.eugen.listview;

/**
 * Created by Eugen on 25.11.2016.
 */

public class StringItem {
    private String text;
    private int count;

    public StringItem(String text){
        this.text = text;
        this.count = 1;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount(){
        this.count++;
    }
}

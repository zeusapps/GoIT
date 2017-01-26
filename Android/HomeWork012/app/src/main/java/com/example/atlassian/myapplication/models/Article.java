package com.example.atlassian.myapplication.models;

public class Article {
    private String _title;
    private String _text;

    public Article(String title, String text) {
        _title = title;
        _text = text;
    }

    public String getTitle() {
        return _title;
    }

    public String getText() {
        return _text;
    }
}

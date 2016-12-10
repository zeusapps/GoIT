package com.example.eugen.navigation.models;

import java.util.Date;

/**
 * Created by Eugen on 10.12.2016.
 */

public class Article {
    private String _id;
    private String _title;
    private String _html;
    private Date _published;
    private String _source;

    public Article(String id, String title, String html, Date published, String source) {
        this._id = id;
        this._title = title;
        this._html = html;
        this._published = published;
        this._source = source;
    }

    public String getId() {
        return _id;
    }

    public String getTitle() {
        return _title;
    }

    public String getHtml() {
        return _html;
    }

    public Date getPublished() {
        return _published;
    }

    public String getSource() {
        return _source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return _id != null ? _id.equals(article._id) : article._id == null;

    }

    @Override
    public int hashCode() {
        return _id != null ? _id.hashCode() : 0;
    }
}

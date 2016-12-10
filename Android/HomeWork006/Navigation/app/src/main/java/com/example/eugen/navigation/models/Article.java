package com.example.eugen.navigation.models;

import java.util.Date;

/**
 * Created by Eugen on 10.12.2016.
 */

public class Article {
    private String id;
    private String title;
    private String html;
    private Date published;
    private String source;

    public Article(String id, String title, String html, Date published, String source) {
        this.id = id;
        this.title = title;
        this.html = html;
        this.published = published;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return id != null ? id.equals(article.id) : article.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

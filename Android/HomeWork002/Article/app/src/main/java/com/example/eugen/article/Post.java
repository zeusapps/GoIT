package com.example.eugen.article;


import java.util.Date;

/**
 * Created by Eugen on 23.11.2016.
 */

public class Post {
    private String author;
    private String subject;
    private String text;
    private Date createdDate;
    private Date editDate;

    public Post(String author, String subject, String text){
        this.author = author;
        this.subject = subject;
        this.text = text;
        this.createdDate = new Date();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}

package com.example.eugen.article;


import java.util.Calendar;
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
        this.createdDate = Calendar.getInstance().getTime();
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void Update(String author, String subject, String text){
        this.author = author;
        this.subject = subject;
        this.text = text;

        this.editDate = Calendar.getInstance().getTime();
    }
}

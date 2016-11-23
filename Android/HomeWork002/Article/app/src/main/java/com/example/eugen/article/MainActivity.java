package com.example.eugen.article;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Post post = new Post();
        post.setAuthor("Eugen");
        post.setSubject("Android");
        post.setText("Android is good");
        post.setCreatedDate(new Date());
    }
}

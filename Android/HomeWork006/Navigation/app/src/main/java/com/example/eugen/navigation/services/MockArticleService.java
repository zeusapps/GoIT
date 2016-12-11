package com.example.eugen.navigation.services;

import android.content.Context;
import com.example.eugen.navigation.R;
import com.example.eugen.navigation.models.Article;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Eugen on 10.12.2016.
 */

public class MockArticleService implements IArticleService {

    private final Article[] _articles;

    public MockArticleService(Context context){
        InputStream stream = context.getResources().openRawResource(R.raw.articles);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder = new StringBuilder();
        String line;
        try{
            while ((line = reader.readLine()) != null) {
                builder.append(line).append('\n');
            }
        }
        catch (Throwable e){
            //
        }
        String json = builder.toString();

        _articles = new GsonBuilder()
                .setDateFormat("yyyy.MM.dd'T'HH:mm:ss")
                .create()
                .fromJson(json, Article[].class);
    }

    @Override
    public Article[] getAll() {
        return _articles;
    }

    @Override
    public Article getById(String id) {

        for (Article article : _articles){
            if (article.getId().equals(id)){
                return article;
            }
        }
        return null;
    }
}
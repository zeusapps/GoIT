package com.example.eugen.navigation.services;

import com.example.eugen.navigation.models.Article;

/**
 * Created by Eugen on 10.12.2016.
 */

public interface IArticleService {
    Article[] getAll();

    Article getById(String id);
}
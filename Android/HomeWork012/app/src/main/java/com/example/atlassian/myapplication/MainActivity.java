package com.example.atlassian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.atlassian.myapplication.fragmants.ArticleViewFragment;
import com.example.atlassian.myapplication.fragmants.ArticlesFragment;
import com.example.atlassian.myapplication.models.Article;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements ArticlesFragment.OnFragmentInteractionListener{

    private ArticleViewFragment _articleViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _articleViewFragment = new ArticleViewFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_articles, new ArticlesFragment())
                .add(R.id.activity_main_viewArticle, _articleViewFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Article article) {
        _articleViewFragment.update(article);
    }
}

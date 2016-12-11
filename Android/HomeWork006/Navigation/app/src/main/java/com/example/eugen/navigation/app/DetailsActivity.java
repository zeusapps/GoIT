package com.example.eugen.navigation.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.eugen.navigation.Common.Constants;
import com.example.eugen.navigation.R;
import com.example.eugen.navigation.models.Article;
import com.example.eugen.navigation.services.IArticleService;
import com.example.eugen.navigation.services.MockArticleService;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Article _article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);


        IArticleService articleService = new MockArticleService(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){

            String id = bundle.getString(Constants.ARTICLE_ID);
            Article article = articleService.getById(id);
            _article = article;

            ((TextView)findViewById(R.id.articleDetailsTitle))
                    .setText(article.getTitle());
            ((TextView)findViewById(R.id.articleDetailsPublished))
                    .setText(article.getPublished().toString());
            ((TextView)findViewById(R.id.articleDetailsSource))
                    .setText(article.getSource());
            ((WebView)findViewById(R.id.articleDetailsWebView))
                    .loadDataWithBaseURL(null, article.getHtml(), "text/html", "UTF-8", null);
        }
    }

    @Override
    public void onClick(View view) {
        Article article = _article;
        if (article == null){
            return;
        }

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_HTML_TEXT, article.getHtml());
        sendIntent.putExtra(Intent.EXTRA_TEXT, article.getTitle());
        sendIntent.putExtra(Intent.EXTRA_TITLE, article.getTitle());
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, article.getTitle());
        sendIntent.setType("text/html");
        startActivity(Intent.createChooser(sendIntent, "Choose the app"));
    }
}

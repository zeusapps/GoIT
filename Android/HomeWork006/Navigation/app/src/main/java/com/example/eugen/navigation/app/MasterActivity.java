package com.example.eugen.navigation.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.eugen.navigation.Common.Constants;
import com.example.eugen.navigation.R;
import com.example.eugen.navigation.adapters.ArticleAdapter;
import com.example.eugen.navigation.models.Article;
import com.example.eugen.navigation.services.IArticleService;
import com.example.eugen.navigation.services.MockArticleService;

public class MasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        IArticleService service = new MockArticleService(this);

        final ArticleAdapter adapter = new ArticleAdapter(this);
        adapter.addAll(service.getAll());

        ListView listView = (ListView) findViewById(R.id.articlesListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Article article = (Article) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(MasterActivity.this, DetailsActivity.class);
                intent.putExtra(Constants.ARTICLE_ID, article.getId());
                startActivity(intent);
            }
        });
    }
}

package com.example.atlassian.myapplication.fragmants;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.atlassian.myapplication.R;
import com.example.atlassian.myapplication.models.Article;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleViewFragment extends Fragment {

    @BindView(R.id.fragment_article_view_title)
    TextView titleTextView;
    @BindView(R.id.fragment_article_view_text)
    TextView textTextView;

    public ArticleViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_view, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    public void update(Article article){
        titleTextView.setText(article.getTitle());
        textTextView.setText(article.getText());
    }

}

package com.example.atlassian.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.atlassian.myapplication.R;
import com.example.atlassian.myapplication.models.Article;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context) {
        super(context, R.layout.fragment_articles_item_template);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArticleViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_articles_item_template, parent, false);
            holder = new ArticleViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ArticleViewHolder) convertView.getTag();
        }

        holder.update(getItem(position));
        return convertView;
    }

    public class ArticleViewHolder{
        @BindView(R.id.fragment_article_item_template_title)
        TextView titleTextView;

        public ArticleViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void update(Article article){
            titleTextView.setText(article.getTitle());
        }
    }
}

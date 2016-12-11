package com.example.eugen.navigation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eugen.navigation.R;
import com.example.eugen.navigation.models.Article;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

/**
 * Created by Eugen on 10.12.2016.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    private Context _context;

    public ArticleAdapter(Context context) {
        super(context, R.layout.article_item_template);

        _context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.article_item_template, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Article article = getItem(position);

        holder.update(article);
        return convertView;
    }

    private class ViewHolder{
        private final TextView _title;
        private final TextView _published;
        private final TextView _source;
        private final SimpleDateFormat format;

        private ViewHolder(View view){
            _title = (TextView) view.findViewById(R.id.articleTemplateTitle);
            _published = (TextView) view.findViewById(R.id.articleTemplatePublished);
            _source = (TextView) view.findViewById(R.id.articleTemplateSource);

            format = new SimpleDateFormat("dd MMM yy HH:mm:ss");
        }

        private void update(Article article){
            _title.setText(article.getTitle());
            _published.setText(format.format(article.getPublished()));
            _source.setText(article.getSource());
        }
    }
}

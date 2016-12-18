package com.example.andrew.testsystem.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.testsystem.Models.Test;
import com.example.andrew.testsystem.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestAdapter extends ArrayAdapter<Test> {

    private Context _context;

    public TestAdapter(Context context) {
        super(context, R.layout.test_item_template);

        _context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.test_item_template, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Test test = getItem(position);

        holder.update(test);
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.test_item_template_name) TextView _nameTextView;
        @BindView(R.id.test_item_template_image) ImageView _imageView;

        private ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

        private void update(Test test){
            _nameTextView.setText(test.getName());

            String url = test.getImage();
            if (url != null){
                Picasso
                        .with(_context)
                        .load(url)
                        .into(_imageView);
            }
        }
    }
}

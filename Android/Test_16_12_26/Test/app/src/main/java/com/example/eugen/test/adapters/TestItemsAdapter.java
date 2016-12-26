package com.example.eugen.test.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eugen.test.R;
import com.example.eugen.test.models.Test;
import com.example.eugen.test.models.TestItem;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eugen on 26.12.2016.
 */

public class TestItemsAdapter extends ArrayAdapter<TestItem> {
    private Context _context;
    private int _resource;

    public TestItemsAdapter(Context context) {
        super(context, R.layout.template_test_item);

        _context = context;
        _resource = R.layout.template_test_item;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(_context)
                    .inflate(_resource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.update(position);
        return convertView;

    }

    class ViewHolder {
        @BindView(R.id.template_test_item_question)
        TextView question;


        private ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        private void update(int position) {
            TestItem item = getItem(position);

            if (item == null) {
                return;
            }

            question.setText(item.getQuestion());
        }
    }
}

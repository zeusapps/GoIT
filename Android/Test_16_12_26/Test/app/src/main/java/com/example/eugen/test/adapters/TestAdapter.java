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

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestAdapter extends ArrayAdapter<Test> {
    private Context _context;
    private int _resource;

    public TestAdapter(Context context) {
        super(context, R.layout.template_test);

        _context = context;
        _resource = R.layout.template_test;
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
        @BindView(R.id.template_test_name)
        TextView nameTextView;
        @BindView(R.id.template_test_questionsCount)
        TextView questionsCountTextView;


        private ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        private void update(int position) {
            Test item = getItem(position);

            if (item == null) {
                return;
            }

            nameTextView.setText(item.getName());
            questionsCountTextView.setText(R.string.test_adapter_questions_count + item.getTestItems().size());
        }
    }
}

package com.example.eugen.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eugen on 27.11.2016.
 */

public class StringItemArrayAdapter extends ArrayAdapter<StringItem> {

    private final Context _context;

    public StringItemArrayAdapter(Context context) {
        super(context, R.layout.item_template);
        _context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_template, parent, false);
        TextView itemText = (TextView) view.findViewById(R.id.itemTemplateText);
        TextView itemCount = (TextView) view.findViewById(R.id.itemTemplateCount);

        StringItem item = getItem(position);

        itemText.setText(item.getText());
        itemCount.setText(String.valueOf(item.getCount()));
        return view;
    }

    @Override
    public void add(StringItem object) {
        boolean addItem = true;
        for (int i = 0; i < getCount(); i++) {
            StringItem item = getItem(i);
            if (item.getText().equals(object.getText())){
                item.increaseCount();
                notifyDataSetChanged();
                addItem = false;
                break;
            }
        }
        if (addItem){
            super.add(object);
            notifyDataSetChanged();
        }
    }
}

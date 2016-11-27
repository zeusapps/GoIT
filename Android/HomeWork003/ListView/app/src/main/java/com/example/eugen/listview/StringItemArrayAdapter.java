package com.example.eugen.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Eugen on 27.11.2016.
 */

public class StringItemArrayAdapter extends ArrayAdapter<StringItem> {

    private final Context _context;
    private final ArrayList<StringItem> _items;

    public StringItemArrayAdapter(Context context, ArrayList<StringItem> items) {
        super(context, R.layout.item_template, items);

        _context = context;
        _items = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_template, parent, false);



        return super.getView(position, convertView, parent);
    }
}

package com.example.eugen.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText _textEditText;
    private ListView _itemsListView;
    private ArrayList<StringItem> _items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        _items = new ArrayList<>();
        _textEditText = (EditText) findViewById(R.id.textEditText);
        _itemsListView = (ListView) findViewById(R.id.itemsListView);

        ArrayAdapter<StringItem> adapter = new ArrayAdapter<>(
                this, R.layout.item_template, _items);
        _itemsListView.setAdapter(adapter);
    }

    public void addItem(View view){

    }
}

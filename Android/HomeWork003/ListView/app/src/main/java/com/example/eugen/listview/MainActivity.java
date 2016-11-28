package com.example.eugen.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private EditText _textEditText;
    private StringItemArrayAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _textEditText = (EditText) findViewById(R.id.textEditText);
        _adapter = new StringItemArrayAdapter(this);

        ListView itemsListView = (ListView) findViewById(R.id.itemsListView);
        itemsListView.setAdapter(_adapter);
    }

    public void addItem(View view) {

        String text = _textEditText.getText()
                .toString()
                .trim();

        if (text.length() > 0) {
            _adapter.add(new StringItem(text));
        }
    }
}
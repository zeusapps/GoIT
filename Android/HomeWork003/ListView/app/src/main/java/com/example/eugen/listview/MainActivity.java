package com.example.eugen.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText textEditText;
    private ListView itemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditText = (EditText) findViewById(R.id.textEditText);
        itemsListView = (ListView) findViewById(R.id.itemsListView);
    }

    public void addItem(View view){

    }
}

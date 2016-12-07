package com.example.eugen.task003;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String NAME_KEY = "Name";
    private EditText editName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.nameEditText);

        load();
    }

    public void onSave(View view){
        save();
    }

    private void save(){
        getPreferences(MODE_PRIVATE)
                .edit()
                .putString(NAME_KEY, editName.getText().toString())
                .apply();
    }

    private void load(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString(NAME_KEY, null);
        if (name != null){
            editName.setText(name);
        }
        else {
            Toast.makeText(this, "Preferences is empty", Toast.LENGTH_SHORT).show();
        }
    }
}

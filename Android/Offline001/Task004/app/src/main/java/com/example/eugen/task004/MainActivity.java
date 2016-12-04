package com.example.eugen.task004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView _progress;
    private EditText _name;
    private EditText _city;
    private Spinner _gender;
    private SeekBar _age;

    private UserAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _name = (EditText) findViewById(R.id.nameEditText);
        _city = (EditText) findViewById(R.id.cityEditText);
        _gender = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.genders,
                android.R.layout.simple_spinner_item);
        _gender.setAdapter(adapter);
        _progress = (TextView) findViewById(R.id.progressTextView);
        _age = (SeekBar) findViewById(R.id.seekBar);
        _age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                _progress.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);
        _adapter = new UserAdapter(this);
        listView.setAdapter(_adapter);
    }

    public void add(View view){
        String name = _name.getText().toString();
        String city = _city.getText().toString();
        String gender = _gender.getSelectedItem().toString();
        int age = _age.getProgress();

        User user = new User(name, gender, age, city);

        if (validateInput(user)){
            _adapter.add(user);
            cleanInput();
        }
    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean validateInput(User user){
        if (user.getName().length() < 3){
            showMessage("Please, specify some name");
            return false;
        }
        if (user.getCity().length() < 3){
            showMessage("Please, specify some city");
            return false;
        }

        if (user.getName().length() > 20){
            showMessage("Name is too long");
            return false;
        }

        if (user.getAge() > 100){
            showMessage("You are too old");
            return false;
        }

        if (user.getAge() < 18){
            showMessage("You are too young");
            return false;
        }

        return true;
    }

    private void cleanInput(){
        _name.setText("");
        _city.setText("");
        _gender.setSelection(0);
        _age.setProgress(0);
    }
}

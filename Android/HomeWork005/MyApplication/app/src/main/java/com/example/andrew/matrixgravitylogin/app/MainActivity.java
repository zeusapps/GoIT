package com.example.andrew.matrixgravitylogin.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andrew.matrixgravitylogin.R;
import com.example.andrew.matrixgravitylogin.models.User;
import com.example.andrew.matrixgravitylogin.adapter.UserAdapter;

public class MainActivity extends AppCompatActivity {

    private final String _user1 = "Eugen";
    private final String _user2 = "Test";
    private final String _password1 = "password";
    private final String _password2 = "test";
    private final String _role1 = "ADMIN";
    private final String _role2 = "user";
    private final String _toast = "Wrong login or password";

    private EditText _login;
    private EditText _password;
    private UserAdapter _userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _login = (EditText) findViewById(R.id.loginEditText);
        _password = (EditText) findViewById(R.id.passwordEditText);
        _userAdapter = new UserAdapter(this);

        ListView listView = (ListView) findViewById(R.id.usersListView);
        listView.setAdapter(_userAdapter);
    }

    public void signIn(View view){

        String login = _login.getText().toString();
        String password = _password.getText().toString();

        if (login.equals(_user1) && password.equals(_password1)){
            _userAdapter.add(new User(_user1, _role1));
            cleanup();
            return;
        }

        if (login.equals(_user2) && password.equals(_password2)){
            _userAdapter.add(new User(_user2, _role2));
            cleanup();
            return;
        }

        Toast.makeText(this, _toast, Toast.LENGTH_SHORT).show();
    }

    private void cleanup(){
        _login.setText("");
        _password.setText("");
    }
}

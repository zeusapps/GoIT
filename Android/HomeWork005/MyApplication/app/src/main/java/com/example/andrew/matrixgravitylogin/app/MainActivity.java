package com.example.andrew.matrixgravitylogin.app;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andrew.matrixgravitylogin.R;
import com.example.andrew.matrixgravitylogin.models.User;
import com.example.andrew.matrixgravitylogin.adapter.UserAdapter;

public class MainActivity extends AppCompatActivity {

    private final String USER1 = "Eugen";
    private final String USER2 = "Test";
    private final String PASSWORD1 = "password";
    private final String PASSWORD2 = "test";
    private final String ROLE1 = "ADMIN";
    private final String ROLE2 = "user";
    private final String SIGNIN_ERROR_TOAST = "Wrong login or password";

    private final String LOGIN = "username";
    private final String PASSWORD = "password";
    private final String REMEMBER = "remember";

    private EditText _login;
    private EditText _password;
    private UserAdapter _userAdapter;
    private CheckBox _remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _login = (EditText) findViewById(R.id.loginEditText);
        _password = (EditText) findViewById(R.id.passwordEditText);
        _remember = (CheckBox) findViewById(R.id.rememberCheckBox);
        _userAdapter = new UserAdapter(this);

        ListView listView = (ListView) findViewById(R.id.usersListView);
        listView.setAdapter(_userAdapter);

        loadData();
    }

    public void signIn(View view){

        String login = _login.getText().toString();
        String password = _password.getText().toString();

        String role = getRole(login, password);
        if (role == null){
            Toast.makeText(this, SIGNIN_ERROR_TOAST, Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(login, role);
        _userAdapter.add(user);
        if (_remember.isChecked()){
            saveUser(login, password, true);
        } else {
            saveUser("", "", false);
        }

        cleanup();
    }

    @Nullable
    private String getRole(String login, String password){
        if (login.equals(USER1) && password.equals(PASSWORD1)){
            return ROLE1;
        }

        if (login.equals(USER2) && password.equals(PASSWORD2)){
            return ROLE2;
        }

        return null;
    }

    private void cleanup(){
        _login.setText("");
        _password.setText("");
    }

    private void saveUser(String login, String password, boolean rememberMe){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        prefs.edit()
                .putString(LOGIN, login)
                .putString(PASSWORD, password)
                .putBoolean(REMEMBER, rememberMe)
                .commit();

    }

    private void loadData(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        _login.setText(prefs.getString(LOGIN, ""));
        _password.setText(prefs.getString(PASSWORD, ""));
        _remember.setChecked(prefs.getBoolean(REMEMBER, false));
    }
}

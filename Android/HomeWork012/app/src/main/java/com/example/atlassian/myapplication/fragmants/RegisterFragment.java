package com.example.atlassian.myapplication.fragmants;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.atlassian.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterFragment extends Fragment {

    @BindView(R.id.fragment_register_login)
    EditText loginEditText;
    @BindView(R.id.fragment_register_password)
    EditText passwordEditText;
    @BindView(R.id.fragment_register_repeatPassword)
    EditText repeatPasswordEditText;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.fragment_register_registerButton)
    public void onRegister(){

        String login = loginEditText.getText().toString();
        if (login.length() < 3){
            showMessage("Login should be longer then 3 chars");
            return;
        }

        String password = passwordEditText.getText().toString();
        if (password.length() < 3){
            showMessage("Password should be longer then 3 chars");
            return;
        }

        String passwordConfirm = repeatPasswordEditText.getText().toString();
        if(!password.equals(passwordConfirm)){
            showMessage("Entered password should match");
            return;
        }

        showMessage("Welcome " + login + "!");
        getActivity().finish();
    }

    private void showMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}

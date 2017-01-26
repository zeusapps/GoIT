package com.example.atlassian.myapplication.fragmants;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.atlassian.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    private OnLoginListener _listener;

    @BindView(R.id.fragment_login_loginText)
    EditText loginEditText;
    @BindView(R.id.fragment_login_passwordText)
    EditText passwordEditText;

    public LoginFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.fragment_login_login)
    public void onLogin(){
        if(_listener != null){
            _listener.onLogin(
                    loginEditText.getText().toString(),
                    passwordEditText.getText().toString());
        }
    }

    @OnClick(R.id.fragment_login_register)
    public void onRegister(){
        if (_listener != null){
            _listener.onRegister();
        }
    }

    @OnClick(R.id.fragment_login_passwordRecover)
    public void onPasswordRecover(){
        if (_listener != null){
            _listener.onPasswordRecover();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginListener) {
            _listener = (OnLoginListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLoginListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _listener = null;
    }
    public interface OnLoginListener {
        void onLogin(String login, String password);
        void onRegister();
        void onPasswordRecover();
    }
}

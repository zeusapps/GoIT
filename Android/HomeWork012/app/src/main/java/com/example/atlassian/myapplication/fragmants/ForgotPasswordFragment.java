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

public class ForgotPasswordFragment extends Fragment {

    @BindView(R.id.fragment_forgot_password_email)
    EditText emailEditText;


    public ForgotPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fragment_forgot_password_send)
    public void onSendEmail(){
        String email = emailEditText.getText().toString();

        if (email.length() < 3){
            Toast.makeText(getActivity(), "Email should be entered", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getActivity(), "Email was sand to " + email, Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

}

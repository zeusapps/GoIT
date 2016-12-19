package com.example.andrew.testsystem.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.andrew.testsystem.Adapters.TestAdapter;
import com.example.andrew.testsystem.Models.Test;
import com.example.andrew.testsystem.R;
import com.example.andrew.testsystem.Repository.TestsRepository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    private static final int CREATE_NEW_TEST_CODE = 66;

    private TestAdapter _adapter;
    private TestsRepository _repository;


    @BindView(R.id.main_testsListView)
    ListView _testsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        _repository = new TestsRepository(this);
        _adapter = new TestAdapter(this);
        _testsListView.setAdapter(_adapter);

        Test[] tests = _repository.getAllTests();
        _adapter.addAll(tests);
    }

    @OnClick(R.id.main_addNewTestButton)
    public void addNewTest(){
        startActivityForResult(new Intent(this, NewTestActivity.class), CREATE_NEW_TEST_CODE);
    }

    @OnItemClick(R.id.main_testsListView)
    public void testSelected(int position){
        long id = _adapter.getItem(position).getId();
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra(Test.ID_FIELD, id);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != CREATE_NEW_TEST_CODE || resultCode != RESULT_OK){
            return;
        }

        Test[] tests = _repository.getAllTests();
        _adapter.clear();
        _adapter.addAll(tests);
    }
}

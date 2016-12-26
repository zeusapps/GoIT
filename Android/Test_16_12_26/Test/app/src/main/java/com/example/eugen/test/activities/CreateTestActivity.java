package com.example.eugen.test.activities;

import android.widget.EditText;
import android.widget.ListView;

import com.example.eugen.test.R;
import com.example.eugen.test.activities.base.BaseAuthActivity;
import com.example.eugen.test.models.Test;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateTestActivity extends BaseAuthActivity {
    @BindView(R.id.create_test_testNameEditText)
    EditText _nameEditText;
    @BindView(R.id.create_test_testItemsListView)
    ListView _testItemsListView;

    @Override
    protected int getResourceId() {
        return R.layout.activity_create_test;
    }

    @OnClick(R.id.create_test_createButton)
    public void create(){
        Test test = new Test(_nameEditText.getText().toString());
        _application.getTestsRepository().addTest(test);

        setResult(RESULT_OK);
        finish();
    }
}

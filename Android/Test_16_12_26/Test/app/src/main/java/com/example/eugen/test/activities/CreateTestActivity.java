package com.example.eugen.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.example.eugen.test.R;
import com.example.eugen.test.activities.base.BaseAuthActivity;
import com.example.eugen.test.adapters.TestItemsAdapter;
import com.example.eugen.test.models.Test;
import com.example.eugen.test.models.TestItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateTestActivity extends BaseAuthActivity {
    private static final int CREATE_NEW_QUESTION_REQUEST_CODE = 77;
    private TestItemsAdapter _adapter;

    @BindView(R.id.create_test_testNameEditText)
    EditText _nameEditText;
    @BindView(R.id.create_test_testItemsListView)
    ListView _testItemsListView;

    @Override
    protected void onCreateCustom(Bundle savedState) {
        super.onCreateCustom(savedState);

        _adapter = new TestItemsAdapter(this);
        _testItemsListView.setAdapter(_adapter);
    }

    @Override
    protected int getResourceId() {
        return R.layout.activity_create_test;
    }

    @OnClick(R.id.create_test_createButton)
    public void create(){
        Test test = new Test(_nameEditText.getText().toString());

        ArrayList<TestItem> items = new ArrayList<>();
        for (int i = 0; i < _adapter.getCount(); i++){
            items.add(_adapter.getItem(i));
        }


        test.getTestItems().addAll(items);
        _application.getTestsRepository().addTest(test);

        setResult(RESULT_OK);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_test_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.create_test_menu_addQuestion){
            startActivityForResult(
                    new Intent(this, CreateTestItemActivity.class),
                    CREATE_NEW_QUESTION_REQUEST_CODE);
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_NEW_QUESTION_REQUEST_CODE && resultCode == RESULT_OK){
            addQuestion(data);
        }
    }

    private void addQuestion(Intent intent){
        TestItem item = new TestItem(
                intent.getStringExtra(TestItem.QUESTIN_EXTRA),
                intent.getStringExtra(TestItem.CORRECT_ANSWER_EXTRA),
                intent.getStringExtra(TestItem.WRONG_ANSWER_1_EXTRA),
                intent.getStringExtra(TestItem.WRONG_ANSWER_2_EXTRA),
                intent.getStringExtra(TestItem.WRONG_ANSWER_3_EXTRA)
        );

        _adapter.add(item);
    }
}

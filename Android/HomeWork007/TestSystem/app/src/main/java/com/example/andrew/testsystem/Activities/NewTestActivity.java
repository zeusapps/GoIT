package com.example.andrew.testsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import com.example.andrew.testsystem.Adapters.TestItemsAdapter;
import com.example.andrew.testsystem.Models.Test;
import com.example.andrew.testsystem.Models.TestItem;
import com.example.andrew.testsystem.R;
import com.example.andrew.testsystem.Repository.TestsRepository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewTestActivity extends AppCompatActivity {

    private final static int ADD_NEW_TEST_ITEM_REQUEST_CODE = 67;

    private TestItemsAdapter _adapter;

    @BindView(R.id.new_test_name)
    EditText nameTextView;
    @BindView(R.id.new_test_image)
    EditText imageTextView;
    @BindView(R.id.new_test_questions)
    ListView questionListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);
        ButterKnife.bind(this);

        _adapter = new TestItemsAdapter(this);
        questionListView.setAdapter(_adapter);
    }

    @OnClick(R.id.new_test_createButton)
    public void create(){
        String name = nameTextView.getText().toString();
        String image = addSchema(imageTextView.getText().toString());

        TestsRepository repository = new TestsRepository(this);
        repository.addTest(new Test(name, image), getAllItems());
        setResult(RESULT_OK);
        finish();
    }

    @OnClick(R.id.new_test_addNewTestItemButton)
    public void addTestItem(){
        startActivityForResult(new Intent(this, NewTestItemActivity.class), ADD_NEW_TEST_ITEM_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != ADD_NEW_TEST_ITEM_REQUEST_CODE || resultCode != RESULT_OK){
            return;
        }

        TestItem item = new TestItem(
                0,
                addSchema(data.getStringExtra(TestItem.IMAGE)),
                data.getStringExtra(TestItem.QUESTION),
                data.getStringExtra(TestItem.CORRECT_ANSWER),
                data.getStringExtra(TestItem.WRONG_ANSWER_1),
                data.getStringExtra(TestItem.WRONG_ANSWER_2),
                data.getStringExtra(TestItem.WRONG_ANSWER_3)
        );
        _adapter.add(item);
    }

    private String addSchema(String url){
        if (!url.startsWith("http://") && !url.startsWith("https://")){
            return "http://" + url;
        }
        return url;
    }

    private TestItem[] getAllItems(){
        int count = _adapter.getCount();
        TestItem[] items = new TestItem[count];
        for (int i = 0; i < count; i++){
            items[i] = _adapter.getItem(i);
        }

        return items;
    }
}

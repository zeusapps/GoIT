package com.example.eugen.test.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.example.eugen.test.R;
import com.example.eugen.test.activities.base.BaseAuthActivity;
import com.example.eugen.test.adapters.TestAdapter;

import butterknife.BindView;

public class MainActivity extends BaseAuthActivity {

    private TestAdapter _adapter;
    @BindView(R.id.main_testsListView)
    ListView _testsListView;

    @Override
    protected void onCreateCustom(Bundle savedState) {
        super.onCreateCustom(savedState);

        _adapter = new TestAdapter(this);
        _testsListView
                .setAdapter(_adapter);
    }

    @Override
    protected int getResourceId() {
        return R.layout.activity_main;
    }
}

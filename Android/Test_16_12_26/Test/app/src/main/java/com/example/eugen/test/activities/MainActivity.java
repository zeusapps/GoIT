package com.example.eugen.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.eugen.test.R;
import com.example.eugen.test.activities.base.BaseAuthActivity;
import com.example.eugen.test.adapters.TestAdapter;
import com.example.eugen.test.enums.AuthRole;

import butterknife.BindView;

public class MainActivity extends BaseAuthActivity {

    private static final int CREATE_NEW_TEST_REQUEST_CODE = 930;

    private TestAdapter _adapter;
    @BindView(R.id.main_testsListView)
    ListView _testsListView;

    @Override
    protected void onCreateCustom(Bundle savedState) {
        super.onCreateCustom(savedState);

        _adapter = new TestAdapter(this);
        refresh();
        _testsListView
                .setAdapter(_adapter);
    }

    @Override
    protected int getResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (_application.getAuthService().getAuthRole() == AuthRole.ADMIN){
            getMenuInflater().inflate(R.menu.main_admin_menu, menu);
            return true;
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_admin_menu_createNew:
                Intent intent = new Intent(this, CreateTestActivity.class);
                startActivityForResult(intent, CREATE_NEW_TEST_REQUEST_CODE);
                return true;
        }

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_NEW_TEST_REQUEST_CODE && resultCode == RESULT_OK){
            refresh();
        }
    }

    private void refresh(){
        _adapter.clear();
        _adapter.addAll(
                _application.getTestsRepository().getTests()
        );
    }
}

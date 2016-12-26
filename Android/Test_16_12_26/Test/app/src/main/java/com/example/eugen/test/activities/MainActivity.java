package com.example.eugen.test.activities;

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

    private TestAdapter _adapter;
    @BindView(R.id.main_testsListView)
    ListView _testsListView;

    @Override
    protected void onCreateCustom(Bundle savedState) {
        super.onCreateCustom(savedState);

        _adapter = new TestAdapter(this);
        _adapter.addAll(
                _application.getTestsRepository().getTests()
        );

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

                return true;
        }

        return false;
    }
}

package com.example.eugen.homework009;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.ActionMode;
import android.widget.Toast;

import com.example.eugen.homework009.adapters.ModelAdapter;
import com.example.eugen.homework009.models.ActionModeCallbackModel;
import com.example.eugen.homework009.models.ModelBase;
import com.example.eugen.homework009.models.PopupModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, ActionMode.Callback, PopupMenu.OnMenuItemClickListener {

    @BindView(R.id.main_modelItemListView)
    ListView _listView;
    private ModelAdapter _adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        _adapter = new ModelAdapter(this, R.layout.template_popup);

        _adapter.add(new PopupModel("popup"));
        _adapter.add(new ActionModeCallbackModel("action mode callback"));

        _listView.setAdapter(_adapter);

        _listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        ModelBase item = _adapter.getItem(position);
        if (item instanceof PopupModel) {
            showPopup(view);
        }

        if (item instanceof ActionModeCallbackModel) {
            showActionMode();
        }
    }

    private void showActionMode() {
        startActionMode(this);
    }

    private void showPopup(View view) {
        PopupMenu menu = new PopupMenu(this, view);
        menu.inflate(R.menu.popup_menu);
        menu.show();

        menu.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        showClicked(item.getTitle().toString());
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        showClicked(item.getTitle().toString());
        return true;
    }

    private void showClicked(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }
}

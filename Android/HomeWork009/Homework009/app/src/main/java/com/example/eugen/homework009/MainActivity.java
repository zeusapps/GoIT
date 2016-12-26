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

import java.util.Comparator;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, ActionMode.Callback, PopupMenu.OnMenuItemClickListener {

    private static final int ITEMS_COUNT = 20;
    private static final int RANDOM_BOUND = 1000;

    @BindView(R.id.main_modelItemListView)
    ListView _listView;
    private ModelAdapter _adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        _adapter = new ModelAdapter(this, R.layout.template_popup);
        randomize();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.options_menu_sort:
                sort();
                showClicked("Items sorted");
                return true;
            case R.id.options_menu_randomize:
                randomize();
                showClicked("Items randomized");
                return true;
        }
        return false;
    }

    private void showClicked(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
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

    private void randomize(){
        Random random = new Random();
        _adapter.clear();
        for (int i = 0; i < ITEMS_COUNT; i++){
            ModelBase model = random.nextBoolean()
                    ? new PopupModel(random.nextInt(RANDOM_BOUND))
                    : new ActionModeCallbackModel(random.nextInt(RANDOM_BOUND));

            _adapter.add(model);
        }
    }

    private void sort(){
        _adapter.sort(new Comparator<ModelBase>() {
            @Override
            public int compare(ModelBase left, ModelBase right) {
                return left.getNumber() - right.getNumber();
            }
        });
    }
}

package com.example.eugen.homework009;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.eugen.homework009.adapters.ModelAdapter;
import com.example.eugen.homework009.models.ActionModeCallbackModel;
import com.example.eugen.homework009.models.PopupModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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
    }
}

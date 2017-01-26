package com.example.atlassian.myapplication.fragmants;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.atlassian.myapplication.R;
import com.example.atlassian.myapplication.adapters.ArticleAdapter;
import com.example.atlassian.myapplication.models.Article;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArticleAdapter _adapter;
    private OnFragmentInteractionListener _listener;

    @BindView(R.id.fragment_article_articles)
    ListView articleListView;

    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        ButterKnife.bind(this, view);

        _adapter = new ArticleAdapter(getActivity());
        _adapter.add(new Article("Title #1", "Text #1"));
        _adapter.add(new Article("Title #2", "Text #2"));
        _adapter.add(new Article("Title #3", "Text #3"));
        _adapter.add(new Article("Title #4", "Text #4"));
        _adapter.add(new Article("Title #5", "Text #5"));

        articleListView.setAdapter(_adapter);
        articleListView.setOnItemClickListener(this);
        return view;
    }

    public void onArticleSelected(Article article) {
        if (_listener != null) {
            _listener.onFragmentInteraction(article);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            _listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _listener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onArticleSelected(_adapter.getItem(position));
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Article article);
    }
}

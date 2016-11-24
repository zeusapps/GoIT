package com.example.eugen.article;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText _authorEditText;
    private EditText _subjectEditText;
    private EditText _textEditText;
    private TextView _createdTextView;
    private TextView _updatedTextView;
    private Post _post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _post = new Post("Eugen", "Android", "Android is good");

        _authorEditText = (EditText) findViewById(R.id.authorEditText);
        _subjectEditText = (EditText) findViewById(R.id.subjectEditText);
        _textEditText = (EditText) findViewById(R.id.textEditText);

        _createdTextView = (TextView) findViewById(R.id.createdTextView);
        _updatedTextView = (TextView) findViewById(R.id.updatedTextView);

        _authorEditText.setText(_post.getAuthor());
        _subjectEditText.setText(_post.getSubject());
        _textEditText.setText(_post.getText());

        printCreated();
        printUpdated();
    }

    public void Save(View view){
        _post.Update(
                _authorEditText.getText().toString(),
                _authorEditText.getText().toString(),
                _authorEditText.getText().toString());

        printUpdated();
    }

    private void printCreated(){
        String text = "Created: " + _post.getCreatedDate();
        _createdTextView.setText(text);
    }

    private void printUpdated(){
        Date updated = _post.getEditDate();

        String text = updated == null
                ? "Post wasn't updated yet"
                : "Updated: " + updated;
        _updatedTextView.setText(text);
    }
}

package com.example.eugen.task004;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

/**
 * Created by Eugen on 29.11.2016.
 */

public class UserAdapter extends ArrayAdapter<User> {

    private Context _context;

    public UserAdapter(Context context) {
        super(context, R.layout.item_template);
        _context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null){
            holder = (ViewHolder) convertView.getTag();
        }
        else {
            LayoutInflater inflater = (LayoutInflater) _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_template, parent, false);
            TextView name = (TextView) convertView.findViewById(R.id.nameTextView);
            TextView city = (TextView) convertView.findViewById(R.id.cityTextView);
            TextView gender = (TextView) convertView.findViewById(R.id.genderTextView);
            TextView age = (TextView) convertView.findViewById(R.id.ageTextView);
            holder = new ViewHolder(name, city, gender, age);
            convertView.setTag(holder);
        }

        User user = getItem(position);

        holder._name.setText("Name: " + user.getName());
        holder._city.setText("City: " + user.getCity());
        holder._gender.setText("Gender: " + user.getGender());
        holder._age.setText("Age: " + user.getAge());

        return convertView;
    }

    private class ViewHolder{
        private TextView _name;
        private TextView _city;
        private TextView _gender;
        private TextView _age;

        public ViewHolder(
                TextView name, TextView city,
                TextView gender, TextView age) {
            this._name = name;
            this._city = city;
            this._gender = gender;
            this._age = age;
        }
    }
}

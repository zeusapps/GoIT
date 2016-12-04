package com.example.andrew.matrixgravitylogin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.andrew.matrixgravitylogin.R;
import com.example.andrew.matrixgravitylogin.models.User;

/**
 * Created by Andrew on 29.11.2016.
 */

public class UserAdapter extends ArrayAdapter<User> {
    private Context _context;

    public UserAdapter(Context context) {
        super(context, R.layout.user_item_template);

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
            convertView = inflater.inflate(R.layout.user_item_template, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        User user = getItem(position);
        holder.update(user);
        return convertView;
    }


    private class ViewHolder{
        private final TextView login;
        private final TextView role;

        private ViewHolder(View view){
            login = (TextView) view.findViewById(R.id.userLoginTextView);
            role = (TextView) view.findViewById(R.id.userRoleTextView);
        }

        private void update(User user){
            login.setText(user.getLogin());
            role.setText(user.getRole());
        }
    }
}

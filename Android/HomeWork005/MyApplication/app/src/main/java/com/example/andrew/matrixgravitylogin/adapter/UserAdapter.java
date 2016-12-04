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
            TextView login = (TextView) convertView.findViewById(R.id.userLoginTextView);
            TextView role = (TextView) convertView.findViewById(R.id.userRoleTextView);
            holder = new ViewHolder(login, role);
            convertView.setTag(holder);
        }

        User user = getItem(position);

        holder.login.setText(user.getLogin());
        holder.role.setText(user.getRole());

        return convertView;
    }


    private class ViewHolder{
        private final TextView login;
        private final TextView role;

        public ViewHolder(TextView login, TextView role){
            this.login = login;
            this.role = role;
        }
    }
}

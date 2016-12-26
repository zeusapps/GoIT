package com.example.eugen.homework009.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eugen.homework009.R;
import com.example.eugen.homework009.models.ActionModeCallbackModel;
import com.example.eugen.homework009.models.ModelBase;
import com.example.eugen.homework009.models.PopupModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class ModelAdapter extends ArrayAdapter<ModelBase> {
    private Context _context;
    private int _resource;

    public ModelAdapter(Context context, int resource) {
        super(context, resource);

        _context = context;
        _resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(_context)
                    .inflate(_resource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.update(position);
        return convertView;

    }

    class ViewHolder {
        @BindView(R.id.template_title)
        TextView titleTextView;

        private ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        private void update(int position) {
            ModelBase item = getItem(position);

            if (item != null) {
                titleTextView.setText(item.getTitle());

                if (item instanceof PopupModel) {
                    titleTextView.setBackgroundColor(
                            _context.getResources().getColor(R.color.popupModel));
                }

                if (item instanceof ActionModeCallbackModel) {
                    titleTextView.setBackgroundColor(
                            _context.getResources().getColor(R.color.actionModeCallbackModel));
                }
            }
        }
    }
}

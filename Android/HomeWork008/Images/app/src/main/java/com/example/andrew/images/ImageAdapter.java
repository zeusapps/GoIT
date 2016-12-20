package com.example.andrew.images;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrew on 20.12.2016.
 */

public class ImageAdapter extends ArrayAdapter<Integer> {

    private Context _context;
    private int _resource;

    public ImageAdapter(Context context, int resource) {
        super(context, resource);

        _context = context;
        _resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(_resource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Integer test = getItem(position);

        holder.update(test);
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.image_item_template_image)
        ImageView _image;

        private ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

        private void update(int resource){
            Picasso
                    .with(_context)
                    .load(resource)
                    .into(_image);
        }
    }
}

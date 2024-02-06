package com.example.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Context mContext;
    private final String[] mItems;
    private final int[] mIcons;

    public CustomListAdapter(Context context, String[] items, int[] icons) {
        super(context, R.layout.list_item_layout, items);
        mContext = context;
        mItems = items;
        mIcons = icons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);

        TextView textView = rowView.findViewById(R.id.textTextView);
        ImageView imageView = rowView.findViewById(R.id.iconImageView);

        textView.setText(mItems[position]);
        imageView.setImageResource(mIcons[position % mIcons.length]); // To avoid ArrayIndexOutOfBoundsException

        return rowView;
    }
}

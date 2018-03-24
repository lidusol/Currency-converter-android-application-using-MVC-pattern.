package com.example.user.drawer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.StringBufferInputStream;

/**
 * Created by user on 5/30/2017.
 */

public class Adapter extends ArrayAdapter<String>{
    Context c;
    String [] countries;
    int [] images;

    public Adapter(Context ctx, String[] countries, int[] images ){
        super(ctx, R.layout.list_row, countries);
        this.c = ctx;
        this.countries = countries;
        this.images = images;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        textView.setText(countries[position]);
        img.setImageResource(images[position]);

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        textView.setText(countries[position]);
        img.setImageResource(images[position]);

        return convertView;
    }
}

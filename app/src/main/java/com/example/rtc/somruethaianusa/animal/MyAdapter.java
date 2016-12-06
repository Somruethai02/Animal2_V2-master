package com.example.rtc.somruethaianusa.animal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by SmilecomputeR on 22/11/2559.
 */

public class MyAdapter extends BaseAdapter {

    //Explicit
    private Context context;
    private String[] titleStrings, imageStrings, detailStrings;
    private TextView titleTextView, detailTextView;
    private ImageView imageView;

    public MyAdapter(Context context,
                     String[] detailStrings,
                     String[] titleStrings,
                     String[] imageStrings) {
        this.context = context;
        this.detailStrings = detailStrings;
        this.titleStrings = titleStrings;
        this.imageStrings = imageStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, parent, false);


        //Bind Widget
        titleTextView = (TextView) view1.findViewById(R.id.textView6);
        detailTextView = (TextView) view1.findViewById(R.id.textView7);
        imageView = (ImageView) view1.findViewById(R.id.imageView);

            //show view
        titleTextView.setText(titleStrings[position]);
        detailTextView.setText(detailStrings[position]);
        Picasso.with(context).load(imageStrings[position]).into(imageView);

        return view1;
    }
}   //Main class

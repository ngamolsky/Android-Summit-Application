package com.example.nikitagamolsky.summitapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nikitagamolsky on 9/2/15.
 */
public class ResultsAdapter extends ArrayAdapter<Results> {
    public ArrayList<Results> resultList;

    public ResultsAdapter(Activity context, ArrayList<Results> resultList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, resultList);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the Movie object from the ArrayAdapter at the appropriate position
        Results result = getItem(position);

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.toast_layout, parent, false);
        }


        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        image.setImageDrawable(result.image);
        TextView text = (TextView) convertView.findViewById(R.id.text);
        text.setText(result.text);
        return convertView;
    }
}
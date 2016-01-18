package com.my.test_tracking.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.my.test_tracking.R;
import com.my.test_tracking.db.Trip;

import java.util.List;

/**
 * Created by Andrew on 18.01.2016.
 */
public class ListTripAdapter extends ArrayAdapter<Trip> {

    List<Trip> trips;

    public ListTripAdapter(Context context) {
        super(context, 0);

    }

    public ListTripAdapter(Context context, List<Trip> trips) {
        super(context, 0, trips);
        this.trips = trips;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Trip trip = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title_trip);
        TextView distance = (TextView) convertView.findViewById(R.id.distance_trip);

        title.setText(trip.title);
        distance.setText(trip.distance);
        return convertView;
    }
}

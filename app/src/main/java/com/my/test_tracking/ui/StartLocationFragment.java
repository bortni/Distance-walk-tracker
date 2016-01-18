package com.my.test_tracking.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.my.test_tracking.LocationService;
import com.my.test_tracking.R;
import com.my.test_tracking.db.Trip;

/**
 * Created by Andrew on 17.01.2016.
 */
public class StartLocationFragment extends Fragment {

    private Button startButton;
    private Button pauseButton;
    private Button stopButton;
    private Button continueButton;
    private EditText tripName;
    private double latitude, longitude;
    private View mainView;
    private BroadcastReceiver broadcastReceiver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_start_location, container, false);
        startButton = (Button) mainView.findViewById(R.id.start_button);
        pauseButton = (Button) mainView.findViewById(R.id.pause_button);
        stopButton = (Button) mainView.findViewById(R.id.stop_button);
        continueButton = (Button) mainView.findViewById(R.id.continue_button);
        tripName = (EditText) mainView.findViewById(R.id.trip_name);

        return mainView;
    }

    @Override
    public void onResume() {
        super.onResume();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationService(true);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(tripName.getText().toString())) {
                    locationService(false);
//                    Trip trip = new Trip(tripName.getText().toString(), "100", "paused");
//                    trip.save();
                    Trip trip = new Trip();
                    trip.title = tripName.getText().toString();
                    trip.distance = "100";
                    trip.save();
                } else {
                    Snackbar.make(mainView, "Enter name of the trip", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        startReceiver();
    }

    private void startReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(LocationService.BROADCAST_ACTION);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                latitude = intent.getDoubleExtra("latitude", -1);
                longitude = intent.getDoubleExtra("longitude", -1);
                updateRemote(latitude, longitude);
            }
        };

        getActivity().registerReceiver(broadcastReceiver, filter);
    }

    private void updateRemote(final double latitude, final double longitude) {
        Location loc1 = new Location("");
        loc1.setLatitude(latitude);
        loc1.setLongitude(longitude);

//        float distanceInMetres = loc2.distanceTo(loc1);
        Log.d("Distance******", " " + latitude + " " + longitude);
    }


    @Override
    public void onPause() {
        super.onDestroy();
        getActivity().unregisterReceiver(broadcastReceiver);
    }


    /**
     * Check location service.
     * true - start.
     * false - stop
     */
    private void locationService(boolean serviceAction) {
        Intent mServiceIntent = new Intent(getActivity(), LocationService.class);
        if (serviceAction)
            getActivity().startService(mServiceIntent);
        else
            getActivity().stopService(mServiceIntent);
    }
}

package com.my.test_tracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Andrew on 17.01.2016.
 */
public class StartLocationFragment extends Fragment {

    private Button startButton;
    private Button pauseButton;
    private Button stopButton;
    private Button continueButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_start_location, container, false);
        startButton = (Button) mainView.findViewById(R.id.start_button);
        pauseButton = (Button) mainView.findViewById(R.id.pause_button);
        stopButton = (Button) mainView.findViewById(R.id.stop_button);
        continueButton = (Button) mainView.findViewById(R.id.continue_button);
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
                locationService(false);
            }
        });

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

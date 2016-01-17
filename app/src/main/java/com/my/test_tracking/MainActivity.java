package com.my.test_tracking;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startButton, pauseButton, stopButton, continueButton;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            final String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this, permissions, 0);
        }

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new StartLocationFragment(), "Start Trip");
        adapter.addFragment(new ListHistoryFragment(), "Show History");
        viewPager.setAdapter(adapter);
    }
//        startButton = (Button) findViewById(R.id.start_button);
//        pauseButton = (Button) findViewById(R.id.pause_button);
//        stopButton = (Button) findViewById(R.id.stop_button);
//        continueButton = (Button) findViewById(R.id.continue_button);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                locationService(true);
//            }
//        });
//
//        pauseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                locationService(false);
//            }
//        });
//
//    }
//
//    /**
//     * Check location service.
//     * true - start.
//     * false - stop
//     */
//    private void locationService(boolean serviceAction) {
//        Intent mServiceIntent = new Intent(this, LocationService.class);
//        if (serviceAction)
//            startService(mServiceIntent);
//        else
//            stopService(mServiceIntent);
//    }
}

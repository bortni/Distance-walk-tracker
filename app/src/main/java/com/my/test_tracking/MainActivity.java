package com.my.test_tracking;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            final String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this ,permissions, 0);
//            Log.e("Permission error", "permission error");
//            return;
        }

        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.start_button);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLocationService();
            }
        });
    }

    /**
     * Check location service.
     */
    private void checkLocationService() {
//        Log.d("CHECK_SERVICE", "Service running: " + (settings.getBoolean("locationService", false) ? "YES" : "NO"));
//
//        if (settings.getBoolean("locationService", false))
//            return;
        Intent mServiceIntent = new Intent(this, LocationService.class);
        startService(mServiceIntent);
    }
}

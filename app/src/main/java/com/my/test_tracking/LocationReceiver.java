package com.my.test_tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;

/**
 * Created by Andrew on 17.01.2016.
 */
public class LocationReceiver extends BroadcastReceiver {

    double latitude, longitude;

    double new_latitude = 59.4233276, new_longitude = 24.7040532;

    @Override
    public void onReceive(final Context context, final Intent calledIntent) {
        Log.d("LOC_RECEIVER", "Location RECEIVED!");

        latitude = calledIntent.getDoubleExtra("latitude", -1);
        longitude = calledIntent.getDoubleExtra("longitude", -1);

        updateRemote(latitude, longitude);

    }

    private void updateRemote(final double latitude, final double longitude) {
        if (latitude != new_latitude && longitude != new_longitude) {
            Location loc1 = new Location("");
            loc1.setLatitude(latitude);
            loc1.setLongitude(longitude);

            Location loc2 = new Location("");
            loc2.setLatitude(new_latitude);
            loc2.setLongitude(new_longitude);


            float distanceInMetres = loc1.distanceTo(loc2);
            Log.d("Distance******", " " + distanceInMetres + " " + latitude + " " + longitude);
            new_latitude = latitude;
            new_longitude = longitude;
        }
    }
}

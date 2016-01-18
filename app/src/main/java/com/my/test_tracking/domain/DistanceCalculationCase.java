package com.my.test_tracking.domain;

import android.location.Location;

import com.my.test_tracking.ui.model.Coordinate;

import java.util.List;

/**
 * Created by Andrew on 18-Jan-16.
 */
public class DistanceCalculationCase {

    public static float calculateDistance(List<Coordinate> coordinates) {

        Location loc1 = new Location("A");
        loc1.setLatitude(coordinates.get(coordinates.size() - 1).getLatitude());
        loc1.setLongitude(coordinates.get(coordinates.size() - 1).getLongitude());

        Location loc2 = new Location("B");
        loc2.setLatitude(coordinates.get(coordinates.size() - 2).getLatitude());
        loc2.setLongitude(coordinates.get(coordinates.size() - 2).getLongitude());


        return loc2.distanceTo(loc1);
    }
}

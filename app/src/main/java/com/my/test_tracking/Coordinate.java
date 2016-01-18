package com.my.test_tracking;

/**
 * Created by bogatenkov on 18-Jan-16.
 */
public class Coordinate {

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Coordinate)) {
            return false;
        }

        Coordinate that = (Coordinate) other;

        return this.longitude == (that.latitude)
                && this.longitude == (that.longitude);
    }

    @Override
    public String toString() {
        return "Latitude: " + getLatitude() + "; Longitude: " + getLongitude();
    }
}

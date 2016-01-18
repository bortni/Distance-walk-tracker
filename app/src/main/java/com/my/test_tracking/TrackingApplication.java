package com.my.test_tracking;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Andrew on 18.01.2016.
 */
public class TrackingApplication extends com.activeandroid.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}

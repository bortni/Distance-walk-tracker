package com.my.test_tracking.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Andrew on 17.01.2016.
 */
@Table(name = "Locations")
public class Locations extends Model {

    @Column(name = "title")
    String title;

    @Column(name = "distance")
    Float distance;

    @Column(name = "state")
    String state;

    public Locations(String title, Float distance, String state) {
        this.title = title;
        this.distance = distance;
        this.state = state;
    }
}

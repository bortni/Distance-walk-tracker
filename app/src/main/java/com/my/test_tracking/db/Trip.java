package com.my.test_tracking.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Andrew on 17.01.2016.
 */
@Table(name = "Trip")
public class Trip extends Model {

    @Column(name = "title")
    public String title;

    @Column(name = "distance")
    public float distance;

    @Column(name = "state")
    public String state;

    public Trip() {
        super();
    }

    public Trip(String title, float distance, String state) {
        super();
        this.title = title;
        this.distance = distance;
        this.state = state;
    }
}

package com.my.test_tracking.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Andrew on 17.01.2016.
 */
@Table(name = "Trip")
public class Trip extends Model {

    @Column(name = "title")
    public String title;

    @Column(name = "distance")
    public String distance;

    @Column(name = "state")
    public String state;

    public Trip() {
        super();
    }

    public Trip(String title, String distance, String state) {
        super();
        this.title = title;
        this.distance = distance;
        this.state = state;
    }

    public static List<Trip> selectAll() {
        return new Select().from(Trip.class).orderBy("Id").execute();
    }
}

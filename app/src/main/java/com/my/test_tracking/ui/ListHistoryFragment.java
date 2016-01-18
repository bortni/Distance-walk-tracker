package com.my.test_tracking.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.my.test_tracking.R;
import com.my.test_tracking.db.Trip;
import com.my.test_tracking.ui.adapter.ListTripAdapter;

/**
 * Created by Andrew on 17.01.2016.
 */
public class ListHistoryFragment extends Fragment {
    private View mainView;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_history, container, false);
        listView = (ListView) mainView.findViewById(R.id.list_trip);
        ListTripAdapter adapter = new ListTripAdapter(getActivity(), Trip.selectAll());
        listView.setAdapter(adapter);
        return mainView;
    }
}

package com.my.test_tracking.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.my.test_tracking.R;
import com.my.test_tracking.db.Trip;
import com.my.test_tracking.ui.adapter.ListTripAdapter;

import java.util.List;

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
        return mainView;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        getLoaderManager().restartLoader(1, null, new LoaderManager.LoaderCallbacks<List<Trip>>() {
            @Override
            public Loader<List<Trip>> onCreateLoader(int id, Bundle args) {
                final AsyncTaskLoader<List<Trip>> loader = new AsyncTaskLoader<List<Trip>>(getActivity()) {
                    @Override
                    public List<Trip> loadInBackground() {
                        return getDataList();
                    }
                };
                loader.forceLoad();

                return loader;
            }

            @Override
            public void onLoadFinished(Loader<List<Trip>> loader, List<Trip> data) {
                ListTripAdapter adapter = new ListTripAdapter(getActivity(), data);

                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
            }

            @Override
            public void onLoaderReset(Loader<List<Trip>> loader) {

            }
        });
    }

    private List<Trip> getDataList() {
        return new Select().from(Trip.class).execute();
    }
}

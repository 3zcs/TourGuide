package me.a3zcs.courtcounter.tourguide.fragments;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.a3zcs.courtcounter.tourguide.adapter.ListAdapter;
import me.a3zcs.courtcounter.tourguide.R;
import me.a3zcs.courtcounter.tourguide.model.Place;

import static me.a3zcs.courtcounter.tourguide.Constant.HISROTY;
import static me.a3zcs.courtcounter.tourguide.Constant.RESTAURANT;


public class HistoricalPlaceFragment extends Fragment {
    RecyclerView recyclerView;

    public static HistoricalPlaceFragment newInstance(List<Place> placeList) {
        List<Place> restaurantPlaces = new ArrayList<>();
        for (Place place: placeList) {
            if (place.getType().equals(HISROTY))
                restaurantPlaces.add(place);
        }

        Bundle args = new Bundle();
        args.putParcelableArrayList(HISROTY, (ArrayList<? extends Parcelable>) restaurantPlaces);
        HistoricalPlaceFragment fragment = new HistoricalPlaceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historcal_place,container,false);
        recyclerView = view.findViewById(R.id.RecyclerView);
        if (getArguments().getParcelableArrayList(HISROTY) != null) {
            List<Place> list = getArguments().getParcelableArrayList(HISROTY);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(new ListAdapter(list, getActivity()));
        }
        return view;
    }
}

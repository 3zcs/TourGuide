package me.a3zcs.courtcounter.tourguide.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

import me.a3zcs.courtcounter.tourguide.R;
import me.a3zcs.courtcounter.tourguide.fragments.EventFragment;
import me.a3zcs.courtcounter.tourguide.fragments.HistoricalPlaceFragment;
import me.a3zcs.courtcounter.tourguide.fragments.RestaurantFragment;
import me.a3zcs.courtcounter.tourguide.fragments.SportsClubFragment;
import me.a3zcs.courtcounter.tourguide.model.Place;

/**
 * Created by root on 19/07/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private final int TAPS_NUMBER = 4;
    Context context;
    private List<Place>places;
    public PagerAdapter(FragmentManager fm,List<Place>placeList,Context context) {
        super(fm);
        places = placeList;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return EventFragment.newInstance(places);

            case 1:
                return HistoricalPlaceFragment.newInstance(places);

            case 2:
                return RestaurantFragment.newInstance(places);

            case 3:
                return SportsClubFragment.newInstance(places);

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TAPS_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        List<String> list = Arrays.asList(context.getString(R.string.event),
                context.getString(R.string.history),
                context.getString(R.string.restaurant),
                context.getString(R.string.sport));
        return list.get(position);
    }
}

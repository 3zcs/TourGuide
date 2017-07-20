package me.a3zcs.courtcounter.tourguide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.a3zcs.courtcounter.tourguide.adapter.PagerAdapter;
import me.a3zcs.courtcounter.tourguide.model.Location;
import me.a3zcs.courtcounter.tourguide.model.Place;

import static me.a3zcs.courtcounter.tourguide.Constant.EVENT;
import static me.a3zcs.courtcounter.tourguide.Constant.HISROTY;
import static me.a3zcs.courtcounter.tourguide.Constant.RESTAURANT;
import static me.a3zcs.courtcounter.tourguide.Constant.SPORT;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        List<Place> places = new ArrayList<>();
        Place place1 = new Place(SPORT,getString(R.string.alhilal),new Location(getString(R.string.alhilal_location)));
        Place place2 = new Place(HISROTY,getString(R.string.king_abdulaziz_muzem),new Location(getString(R.string.museum_location)));
        Place place3 = new Place(RESTAURANT,getString(R.string.alromnceah_restaurant),new Location(getString(R.string.alromnceah_restaurant_location)));
        Place place4 = new Place(EVENT,getString(R.string.maker_fair),new Location(getString(R.string.maker_location)));
        places.add(place1);
        places.add(place2);
        places.add(place3);
        places.add(place4);

        fragmentPagerAdapter = new PagerAdapter(getSupportFragmentManager(),places);
        viewPager.setAdapter(fragmentPagerAdapter);
    }
}

package me.a3zcs.courtcounter.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.a3zcs.courtcounter.tourguide.model.Place;

import static me.a3zcs.courtcounter.tourguide.Constant.PLACE;

public class DetailActivity extends AppCompatActivity {

    TextView place,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        Place placeObject = i.getParcelableExtra(PLACE);
        if (placeObject != null) {
            place = (TextView) findViewById(R.id.textView_place);
            address = (TextView) findViewById(R.id.textView_address);
            place.setText(placeObject.getName());
            address.setText(placeObject.getLocation().getLocation());
        }
    }
}

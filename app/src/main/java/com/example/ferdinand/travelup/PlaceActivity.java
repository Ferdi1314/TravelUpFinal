package com.example.ferdinand.travelup;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlaceActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private TextView tvPlace, tvAddress, tvRating;
    private ImageView ivPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Intent intent = getIntent();
        String namePlace = intent.getExtras().getString("nama");
        String address = intent.getExtras().getString("address");
        String review = intent.getExtras().getString("reviews");
        int image = intent.getExtras().getInt("thumbnail");
        ImageView backIcon = (ImageView) findViewById(R.id.backarrow);
        backIcon.setOnClickListener(this);

        tvPlace = findViewById(R.id.name);
        tvAddress = findViewById(R.id.address);
        tvRating = findViewById(R.id.rating);
        ivPlace = findViewById(R.id.imgPlace);

        tvPlace.setText(namePlace);
        tvAddress.setText(address);
        tvRating.setText(review);
        ivPlace.setImageResource(image);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // onMapReady method is used to display the map and a marker to locate the place more specific.
    @Override

    public void onMapReady(GoogleMap googleMap) {
        Intent intent = getIntent();
        String namePlace = intent.getExtras().getString("nama");
        Double latitude = intent.getExtras().getDouble("latitude");
        Double longitude = intent.getExtras().getDouble("longitude");
        mMap = googleMap;

        LatLng place = new LatLng(latitude, longitude );
        mMap.addMarker(new MarkerOptions().position(place).title(namePlace));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 16.0f));
    }

    // onClick method is an implementation of the OnClickListener interface, and therefore it applies
    // the polymorphism concept.
    public void onClick(View v) {
        if (v.getId() == R.id.backarrow) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
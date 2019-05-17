package com.example.loginactivity;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class EventActivity extends AppCompatActivity implements OnMapReadyCallback {
    private TextView name;
    private TextView date;
    private TextView description;
    private TextView location;
    private TextView time;
    private String temp;
    private MapView mapView;
    private GoogleMap map;
    public Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Bundle extras = getIntent().getExtras();

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


        name = findViewById(R.id.tvEventName);
        date = findViewById(R.id.tvEventDate);
        time = findViewById(R.id.tvEventTime);
        description = findViewById(R.id.tvEventDescription);
        btnRegister = findViewById(R.id.btnRegister);
        location = findViewById(R.id.tvEventLocation);

        if (extras != null) {
            name.setText(extras.getString("eventName"));
            date.setText(extras.getString("eventDate"));
            time.setText(extras.getString("eventTime"));
            description.setText(extras.getString("eventDescription"));
            location.setText(extras.getString("eventLocation"));
        }

        temp = extras.getString("eventLocation");

    }

    public LatLng getLocationFromAddress(String strAddress) {
        Geocoder gc = new Geocoder(this);
        LatLng p1 = null;
        try {
            List<Address> addresses = gc.getFromLocationName(strAddress, 1);
            if (addresses.size() >= 1) {
                Address location = addresses.get(0);
                p1 = new LatLng(location.getLatitude(), location.getLongitude());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return p1;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng location = getLocationFromAddress(temp);
        map.addMarker(new MarkerOptions().position(location).title("Event Location"));
        map.moveCamera(CameraUpdateFactory.newLatLng(location));
        map.animateCamera(CameraUpdateFactory.zoomTo(16));
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

}

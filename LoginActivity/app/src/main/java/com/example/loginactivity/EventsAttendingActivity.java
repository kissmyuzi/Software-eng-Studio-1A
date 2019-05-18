package com.example.loginactivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsAttendingActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnAddEvent;
    private ImageButton homeBtn;
    private TextView tvAllEvents;

    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Event> storage = EventStorage.getEvents();

    private void popList(ArrayList<Event> events) { //just to replace user data for now
        for (Event item: storage) {
            events.add(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventattending);
        recyclerView = (RecyclerView) findViewById(R.id.rvEvents);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        popList(events); //garbage until user data can be received
        btnAddEvent = findViewById(R.id.btnAddEvent);
        btnAddEvent.setOnClickListener(this);
        mAdapter = new AdaptorEvent(events);
        recyclerView.setAdapter(mAdapter);

        tvAllEvents= (TextView) findViewById(R.id.tvAllEvents);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/BadBlocks");
        tvAllEvents.setTypeface(myCustomFont);
    }

    @Override
    public void onClick(View v) {
        if (v == btnAddEvent) {
            startActivity(new Intent(EventsAttendingActivity.this, AddEventActivity.class));
        }
    }

    public void homeBtn(View view) {
        startActivity(new Intent(getApplicationContext(),StudentDashboardActivity.class));
    }
}

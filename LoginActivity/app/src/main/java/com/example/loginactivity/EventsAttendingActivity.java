package com.example.loginactivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.card.MaterialCardView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.res.TypedArray;
import android.content.Context;
import java.util.ArrayList;


public class EventsAttendingActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnAddEvent;
    private ImageButton profileBtn;
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        setCardViewBackgroundToRecyclerView(recyclerView);

        popList(events); //garbage until user data can be received
        btnAddEvent = findViewById(R.id.btnAddEvent);
        btnAddEvent.setOnClickListener(this);
        profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(this);
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

        if (v == profileBtn) {
            startActivity(new Intent(EventsAttendingActivity.this, UserActivity.class));
        }
    }

    public void homeBtn(View view) {
        startActivity(new Intent(getApplicationContext(),StudentDashboardActivity.class));
    }

    public void searchBtn(View view) {
        startActivity(new Intent(getApplicationContext(), searchActivity.class));
    }


    public void profileBtn(View view) {
        startActivity(new Intent(getApplicationContext(), UserActivity.class));
    }

    public void eventBtn(View view) {
        startActivity(new Intent(getApplicationContext(), EventsAttendingActivity.class));
        finish();
    }

    private void setCardViewBackgroundToRecyclerView(RecyclerView recyclerView) {

        MaterialCardView cardView = new MaterialCardView(this);
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
        cardView.setUseCompatPadding(true);
        cardView.setPreventCornerOverlap(false);
        cardView.setRadius(65);
        cardView.isClickable();
        int cardShadow = (int) cardView.getCardElevation();
        recyclerView.setPadding(cardView.getContentPaddingLeft() + cardShadow,
                cardView.getContentPaddingTop() + cardShadow + 3,
                cardView.getContentPaddingRight() + cardShadow,
                cardView.getContentPaddingBottom() + cardShadow + 3);
        ViewCompat.setElevation(recyclerView, 8);
        recyclerView.setBackground(cardView.getBackground());

    }
}

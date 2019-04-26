package com.example.loginactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class StudentDashboardActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Event> events = new ArrayList<>();

    private void popList(ArrayList<Event> events) { //just to replace user data for now
        events.add(new Event("1234", "1234", "1234", "Event 1", "Sydney", "19/04/20"));
        events.add(new Event("123", "1234", "1234", "Event 2", "Darwin", "19/04/20"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdashboard);
        recyclerView = (RecyclerView) findViewById(R.id.rvEventAttending);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        popList(events); //garbage until user data can be received

        mAdapter = new AdaptorEvent(events);
        recyclerView.setAdapter(mAdapter);
    }
}

package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.common.internal.SignInButtonImpl;

import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class StudentDashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button btnUpload;
    private Button homeBtn;
    private Button searchBtn;
    private Button profileBtn;
    private Button eventBtn;


    private ArrayList<Event> events = new ArrayList<>();

    private void popList(ArrayList<Event> events) { //just to replace user data for now
        events.add(new Event("1234", "1234", "1234", "A Crash Course On Year 8 Mathematics", "Redfern, 261-265 Chalmers St", "05/07/19", "hello"));
        events.add(new Event("123", "1234", "1234", "The Crucible: A Technical Analysis", "Surry Hills, 56-60 Albion St", "25/08/19", "hello"));
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
        btnUpload = findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(this);
        mAdapter = new AdaptorEvent(events);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == btnUpload) {
            startActivity(new Intent(StudentDashboardActivity.this, UploadFile.class));
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
        startActivity(new Intent(getApplicationContext(), Event.class));
    }
}

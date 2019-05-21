package com.example.loginactivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;


import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class StudentDashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnUpload;
    private ImageButton homeBtn;
    private ImageButton searchBtn;
    private ImageButton profileBtn;
    private ImageButton eventBtn;
    private TextView tvEventTitle;
    private Button add_info;


    private ArrayList<Event> events = new ArrayList<>();

    private void popList(ArrayList<Event> events) { //just to replace user data for now
        for (Event item: UserStorage.getEvents()) {
            events.add(item);
        }
        /*   events.add(new Event("1234", "1234", "1234", "A Crash Course On Year 8 Mathematics", "Redfern, 261-265 Chalmers St", "05/07/19", "Lorem ipsum dolor sit amet, an per tacimates electram temporibus, in quis amet theophrastus est, vim omnis audire temporibus ea. Ne quas affert epicurei mei. Quo suscipit recteque ad, eu expetenda splendide honestatis quo, no vis epicurei mnesarchum. Omittam conceptam concludaturque nec id, quod suscipiantur nam ea.\n" +
                "\n" +
                "Quando minimum omittantur est ad. Agam essent aeterno eu eum. Ei sed tation tibique verterem, ut sit primis deleniti definitionem. No ius enim congue elaboraret, et vim idque mollis.\n" +
                "\n" +
                "An quot solet mei. Ut qui affert praesent, id mel dico solum persius. Essent tacimates ea vel, vel ut fugit exerci conceptam. Qualisque delicatissimi ex qui. Apeirian consetetur eos in, quaeque vocibus forensibus cu per, has in convenire contentiones.\n" +
                "\n" +
                "Delenit offendit ea eum, mel vero mundi an. Tibique corpora vix id. Eos cu tamquam dolorum, propriae molestiae cotidieque sit id, quaerendum contentiones an quo. Sed vidit mazim an, te vis idque quidam, ne vim scribentur necessitatibus.", "11:30"));
        events.add(new Event("123", "1234", "1234", "The Crucible: A Technical Analysis", "Surry Hills, 56-60 Albion St", "25/08/19", "Lorem ipsum dolor sit amet, an per tacimates electram temporibus, in quis amet theophrastus est, vim omnis audire temporibus ea. Ne quas affert epicurei mei. Quo suscipit recteque ad, eu expetenda splendide honestatis quo, no vis epicurei mnesarchum. Omittam conceptam concludaturque nec id, quod suscipiantur nam ea.\n" +
                "\n" +
                "Quando minimum omittantur est ad. Agam essent aeterno eu eum. Ei sed tation tibique verterem, ut sit primis deleniti definitionem. No ius enim congue elaboraret, et vim idque mollis.\n" +
                "\n" +
                "An quot solet mei. Ut qui affert praesent, id mel dico solum persius. Essent tacimates ea vel, vel ut fugit exerci conceptam. Qualisque delicatissimi ex qui. Apeirian consetetur eos in, quaeque vocibus forensibus cu per, has in convenire contentiones.\n" +
                "\n" +
                "Delenit offendit ea eum, mel vero mundi an. Tibique corpora vix id. Eos cu tamquam dolorum, propriae molestiae cotidieque sit id, quaerendum contentiones an quo. Sed vidit mazim an, te vis idque quidam, ne vim scribentur necessitatibus.", "14:00"));

    */}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentdashboard);
        recyclerView = findViewById(R.id.rvEventAttending);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        popList(events); //garbage until user data can be received
        btnUpload = findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(this);
        eventBtn = findViewById(R.id.eventBtn);
        eventBtn.setOnClickListener(this);
        mAdapter = new AdaptorEvent(events);
        recyclerView.setAdapter(mAdapter);

        add_info = findViewById(R.id.add_info);
        add_info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, AddInfoActivity.class));
            }
        });


        searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentDashboardActivity.this, RecyclerViewActivity.class));
            }
        });

        tvEventTitle= findViewById(R.id.tvEventTitle);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/BadBlocks");
        tvEventTitle.setTypeface(myCustomFont);
    }

    @Override
    public void onClick(View view) {

        if (view == btnUpload) {
            startActivity(new Intent(getApplicationContext(), UploadFile.class));
        } else if (view == eventBtn) {
            startActivity(new Intent(StudentDashboardActivity.this, EventsAttendingActivity.class));
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
}

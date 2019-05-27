package com.example.loginactivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvAddEvent;
    private EditText etName;
    private EditText etDate;
    private EditText etLocation;
    private EditText etDescription;
    private EditText etTime;
    private ImageButton ibBack;
    private Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);
        etName = findViewById(R.id.etName);
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        ibBack = findViewById(R.id.btnBack);

        tvAddEvent = findViewById(R.id.tvAddEvent);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/BadBlocks");
        tvAddEvent.setTypeface(myCustomFont);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        String location = etLocation.getText().toString().trim();
        String time = etTime.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        if (v == btnSubmit) {
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this,"Please enter an event name", Toast.LENGTH_SHORT).show();
                etName.requestFocus();
                return;
            }
            else if (TextUtils.isEmpty(date) || date.length() != 8) {
                Toast.makeText(this,"Please enter a date in the format: DD/MM/YY", Toast.LENGTH_LONG).show();
                etDate.requestFocus();
                return;
            }
            else if (TextUtils.isEmpty(time) || time.length() != 5) {
                Toast.makeText(this,"Please enter a time in 24 hour format", Toast.LENGTH_LONG).show();
                etTime.requestFocus();
                return;
            }
            else if (TextUtils.isEmpty(location) && location.length() < 10) {
                Toast.makeText(this,"Please enter an address", Toast.LENGTH_SHORT).show();
                etLocation.requestFocus();
                return;
            }
            else if (TextUtils.isEmpty(description)) {
                Toast.makeText(this,"Please enter a description", Toast.LENGTH_SHORT).show();
                etDescription.requestFocus();
                return;
            }
            else {
                EventStorage.addEvent(name, date, location, description, time);
                UserStorage.addEvent(name, date, location, description, time);
                startActivity(new Intent(AddEventActivity.this, EventsAttendingActivity.class));
            }
        }
        if (v == ibBack){
            startActivity(new Intent(getApplicationContext(), EventsAttendingActivity.class));
        }
    }
}

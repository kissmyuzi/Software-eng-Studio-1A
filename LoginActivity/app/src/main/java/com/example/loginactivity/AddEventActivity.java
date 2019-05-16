package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etDate;
    private EditText etLocation;
    private EditText etDescription;
    private Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);
        etName = findViewById(R.id.etName);
        etDate = findViewById(R.id.etDate);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        String location = etLocation.getText().toString().trim();
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
                EventStorage.addEvent(name, date, location, description);
                startActivity(new Intent(AddEventActivity.this, EventsAttendingActivity.class));
            }
        }
    }
}

package com.example.loginactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Donation {
    private String donationId;
    private String charityId;
    private String tutoredIn;
    private String state;
    private int grade;
    private String date;


    public Donation(String donationId, String charityId, String tutoredIn, String state,
                    int grade, String date) {
        this.donationId = donationId;
        this.charityId = charityId;
        this.tutoredIn = tutoredIn;
        this.state = state;
        this.grade = grade;
        this.date = date;
    }

    public String donationId() {
        return donationId;
    }
    public String charityId() {
        return charityId;
    }
    public String tutoredIn() {
        return tutoredIn;
    }
    public String state() {
        return state;
    }
    public int grade() {
        return grade;
    }
    public String date() {
        return date;
    }
}

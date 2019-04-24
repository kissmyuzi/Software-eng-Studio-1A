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


public class Note {
    private String noteId;
    private String noteIcon;
    private String noteName;
    private String subject;
    private int grade;
    private String state;
    private String date;
    private String fileExt;

    public Note(String noteId, String noteIcon, String noteName, String subject, int grade, String state,
                String date , String fileExt) {
        this.noteId = noteId;
        this.noteIcon = noteIcon;
        this.noteName = noteName;
        this.subject = subject;
        this.grade = grade;
        this.state = state;
        this.date = date;
        this.fileExt = fileExt;
    }

    public String noteId() {
        return noteId;
    }

    public String noteIcon() {
        return noteIcon;
    }

    public String noteName() {
        return noteName;
    }

    public int grade() {
        return grade;
    }

    public String state() {
        return state;
    }

    public String date() {
        return date;
    }

    public String fileExt() {
        return fileExt;
    }

}

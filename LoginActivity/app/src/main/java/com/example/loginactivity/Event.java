package com.example.loginactivity;

<<<<<<< HEAD
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


public class Event {
    private String eventId;
    private String userId;
    private String eventIcon;
=======

public class Event {
    private String eventId;
    private String userIcon;
    private String eventIcon; //change data type when possible
>>>>>>> master
    private String eventName;
    private String location;
    private String date;

<<<<<<< HEAD
    public Event(String eventId, String userId, String eventIcon, String eventName,
                 String location, String date) {
        this.eventId = eventId;
        this.userId = userId;
=======

    public Event(String eventId, String userIcon, String eventIcon, String eventName, String location, String date) {
        this.eventId = eventId;
        this.userIcon = userIcon;
>>>>>>> master
        this.eventIcon = eventIcon;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
    }

<<<<<<< HEAD
    public String eventId() {
        return eventId;
    }
    public String userId() {
        return userId;
    }
    public String eventIcon() {
        return eventIcon;
    }
    public String eventName() {
        return eventName;
    }
    public String location() {
        return location;
    }
    public String date() {
        return date;
    }

}

=======
    public String getEventId() {
        return eventId;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public String getEventIcon() {
        return eventIcon;
    }

    public String getEventName() {
        return eventName;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
>>>>>>> master

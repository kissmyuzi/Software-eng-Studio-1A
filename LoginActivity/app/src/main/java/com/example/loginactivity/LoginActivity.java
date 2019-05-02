package com.example.loginactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

        private Button btnSignIn;
        private EditText etEmailAddress;
        private EditText etPassword;
        private TextView tvSignUp;
        private FirebaseAuth mAuth;
        private ProgressDialog progressDialog;
        private TextView tvResetPassword;
        public DatabaseReference mDatabase;
        public String id;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            mAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance().getReference("users");
            progressDialog = new ProgressDialog(this);

            etEmailAddress = findViewById(R.id.etEmail);
            etPassword = findViewById(R.id.etPassword);
            btnSignIn = findViewById(R.id.btnSignIn);
            tvSignUp = findViewById(R.id.tvSignUp);
            tvResetPassword = findViewById(R.id.tvResetPassword);

            btnSignIn.setOnClickListener(this);
            tvSignUp.setOnClickListener(this);
            tvResetPassword.setOnClickListener(this);
        }

    public void checkEmailVerification() {
        startActivity(new Intent(LoginActivity.this, StudentDashboardActivity.class));
        FirebaseUser firebaseUser = mAuth.getInstance().getCurrentUser();
        Boolean emailFlag = firebaseUser.isEmailVerified();
        id = mAuth.getCurrentUser().getUid();

        if(emailFlag) {
            mDatabase.child(id).addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Map<String, Object> user = (Map<String, Object>) dataSnapshot.getValue();

                    String userType = (String) user.get("userType");
                    if(userType.equals("Student")) {
                        startActivity(new Intent(LoginActivity.this, StudentDashboardActivity.class));
                    }
                    else {
                       startActivity(new Intent(LoginActivity.this, StudentDashboardActivity.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        } else {
            Toast.makeText(this, "Verify your email address", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
        }
    }

    private void userLogin(){
        String emailAddress = etEmailAddress.getText().toString().trim();
        String password = etPassword.getText().toString().trim();


        //Validation method ensuring user has entered email and password to register
        //When the user did not enter anything to the email field
        if(TextUtils.isEmpty(emailAddress)) {
            Toast.makeText(this,"Please enter your email", Toast.LENGTH_SHORT).show();
            etEmailAddress.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show();
            etEmailAddress.requestFocus();
            return;
        }

        //If the validation is successful, show login progress
        progressDialog.setMessage("Logging in is in Process, Please Wait");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(emailAddress,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isCanceled()) {
                            Toast.makeText(getBaseContext(),"Something went wrong in the system", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(!task.isSuccessful()) {
                            Toast.makeText(getBaseContext(),"Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(task.isSuccessful()){
                            checkEmailVerification();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == btnSignIn) {
            userLogin();
          //  overridePendingTransition(0, 0);                                        //Remove activity transition
        }

        if (view == tvResetPassword) {
            finish();
            startActivity(new Intent(this,ResetPasswordActivity.class));
        }

        if(view == tvSignUp) {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
/*
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            //  | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN                               This Line Hides the status bar 1/2
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            // | View.SYSTEM_UI_FLAG_FULLSCREEN                                      This Line Hides the status bar 2/2
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
  */
}
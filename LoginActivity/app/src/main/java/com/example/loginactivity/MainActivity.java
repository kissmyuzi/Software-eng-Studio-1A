package com.example.loginactivity;

import android.app.ProgressDialog;
import android.content.Intent;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ayyLmao = "RegisterActivity";


    private Button btnRegister;
    private EditText etEmail;
    private EditText etPassword;
    private TextView tvSignIn;
    private EditText etFirstName;
    private EditText etLastName;
    private Spinner spUserType;
    private EditText etCharityOrg;

    private ProgressDialog progressDialog;

    public FirebaseAuth mAuth;
    public DatabaseReference mDatabase;

    public String id;

    public User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION); //hIDING nAVIGATION bAR


        progressDialog = new ProgressDialog(this);

        //Check if the user is signed in, if the user is signed in
        //Then re-direct the user to Main page
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), UserActivity.class));
        }

        mDatabase = FirebaseDatabase.getInstance().getReference("users");

        btnRegister = (Button) findViewById(R.id.btnRegister);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvSignIn = (TextView) findViewById(R.id.tvSignin);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        spUserType = (Spinner) findViewById(R.id.spUserType);
        etCharityOrg = (EditText) findViewById(R.id.etCharityOrg);

        btnRegister.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);
    }

    private void sendEmailVerification() {
        FirebaseUser firebaseUser = mAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Successfully Registered, Please check your email address for verfication email", Toast.LENGTH_SHORT).show();
                        mAuth.signOut();
                        finish();
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Something error with the email verification, Please Try again later", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void registerUser() {
        final String emailAddress = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String firstName = etFirstName.getText().toString().trim();
        final String lastName = etLastName.getText().toString().trim();
        final String userType = spUserType.getSelectedItem().toString().trim();
        final String charityOrg = etCharityOrg.getText().toString().trim();


        //Validation method that ensures that the user has entered email and password to register
        //When the user did not enter anything to the email field
        //Stop the except and provide an exception error
        if (TextUtils.isEmpty(firstName)) {
            Toast.makeText(this, "Please enter your first name", Toast.LENGTH_SHORT).show();
            etFirstName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            Toast.makeText(this, "Please enter your last name", Toast.LENGTH_SHORT).show();
            etLastName.requestFocus();
            return;
        }

        if (!emailAddress.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            Toast.makeText(this, "Please enter your email in correct format", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        }


        if (TextUtils.isEmpty(emailAddress)) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 9) {
            Toast.makeText(this, "Please enter more than 8 characters for your password", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(charityOrg)) {
            Toast.makeText(this, "Please enter your affiliated charity organisation", Toast.LENGTH_SHORT).show();
            etCharityOrg.requestFocus();
            return;
        }


        //If the validation is successful, show registration progress
        progressDialog.setMessage("Registering in Process, Please Wait");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(emailAddress, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Sign in success, update UI with the signed-in
                            FirebaseUser userAuth = mAuth.getCurrentUser();
                            String spUTData = spUserType.getSelectedItem().toString();
                            id = userAuth.getUid();
                            if (spUTData.equals("Student")) { //if the person is a student, make them a user
                                user = new User(id, firstName, lastName, emailAddress, password, userType, charityOrg);
                            }
                            else if (spUTData.equals("Tutor")) { //or if they are a tutor, make them a tutor
                                user = new Tutor(id, firstName, lastName, emailAddress, password, userType, charityOrg, true);
                            }
                            mDatabase.child(id).setValue(user);
                            progressDialog.dismiss();
                            sendEmailVerification();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override

    public void onClick(View view) {

        if (view == btnRegister) {
            registerUser();
            startActivity(new Intent(MainActivity.this, StudentDashboardActivity.class));
        }

        if (view == tvSignIn) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
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

}

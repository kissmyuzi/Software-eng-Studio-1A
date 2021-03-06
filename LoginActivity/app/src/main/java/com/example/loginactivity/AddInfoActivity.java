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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1.Value;

//import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;


public class AddInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ayyLmao = "";


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
    public DatabaseReference mDatabase, mUserRef;
    public FirebaseUser mUser;

    private FirebaseFirestore db;

    public String id, mUserID, mCurrentUserID;

    public User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addinfo);

        //find user
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mUserID = mUser.getUid();

        //Check if the user is signed in, if the user is signed in
        //Then re-direct the user to Main page

        mAuth = FirebaseAuth.getInstance();
        mCurrentUserID = mAuth.getCurrentUser().getUid();
        mUserRef = FirebaseDatabase.getInstance().getReference().child( "Users" ).child(mCurrentUserID);

        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION); //hIDING nAVIGATION bAR

        progressDialog = new ProgressDialog(this);


        mDatabase = FirebaseDatabase.getInstance().getReference();



        // Adding information EditText
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        //spUserType = findViewById(R.id.spUserType);
        etCharityOrg = findViewById(R.id.etCharityOrg);

        // Save Button
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }


    private void registerUser() {
        final String firstName = etFirstName.getText().toString().trim();
        final String lastName = etLastName.getText().toString().trim();
        //final String userType = spUserType.getSelectedItem().toString().trim();
        final String charityOrg = etCharityOrg.getText().toString().trim();

        // Adding to a database map

        HashMap userMap = new HashMap();
        //HashMap<String, Object> userMap = new HashMap<String, Object>();

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
/**
        if (!emailAddress.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+))")) {
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
**/
        if (TextUtils.isEmpty(charityOrg)) {
            Toast.makeText(this, "Please enter your affiliated charity organisation", Toast.LENGTH_SHORT).show();
            etCharityOrg.requestFocus();
            return;
        } else {

            userMap.put( "firstName", firstName);
            userMap.put("lastName",lastName);
            userMap.put("charityOrg",charityOrg);
        }


        mUserRef.updateChildren(userMap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    //If the validation is successful, show registration progress
                    //progressDialog.setMessage("Registering in Process, Please Wait");
                    //progressDialog.show();
                    finish();
                } else {
                    //String message = task.getException().getMessage();

                    //progressDialog.setMessage("Registration Incomplete. Please fill out all boxes.");
                    //progressDialog.show();
                }
            }
        });
}

    @Override
    public void onClick(View view) {
    }

}

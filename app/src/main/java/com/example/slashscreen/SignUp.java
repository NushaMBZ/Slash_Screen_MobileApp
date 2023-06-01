package com.example.slashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, locationEditText;
    private Button signUpButton;
    private TextView signInTextView;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbHelper = new DBHelper(this);

        signInTextView = findViewById(R.id.signIn);
        signUpButton = findViewById(R.id.btnSign);
        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        locationEditText = findViewById(R.id.location);

        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String location = locationEditText.getText().toString().trim();

                if (name.equals("") || location.equals("") || email.equals("") || password.equals("")) {
                    Toast.makeText(SignUp.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else if (dbHelper.checkEmailExists(email)) {
                    Toast.makeText(SignUp.this, "Email already exists", Toast.LENGTH_SHORT).show();
                } else if (dbHelper.checkNameAndLocationExists(name, location)) {
                    Toast.makeText(SignUp.this, "Name and location already exists", Toast.LENGTH_SHORT).show();
                } else {
                    boolean notSuccess = dbHelper.insertData(name, location, email, password);
                    if (notSuccess) {
                        Toast.makeText(SignUp.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUp.this, "Sign up Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, Dashboard.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}

package com.example.slashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    Button logIn;
    EditText email, password;
    TextView forgotPassword, logInSignUp;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        dbHelper = new DBHelper(this);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        logIn = findViewById(R.id.btnlogin);
        logInSignUp = findViewById(R.id.sgnup);
        forgotPassword = findViewById(R.id.forgotpassword);

        logInSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });


        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, ResetPassword.class);
                startActivity(intent);
            }
        });

        logIn.setOnClickListener( view -> {
                String userEmail = email.getText().toString().trim();
                String userPassword = password.getText().toString().trim();

                if (userEmail.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(LogIn.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                } else {
                    boolean loginSuccess = dbHelper.checkUserExists(userEmail, userPassword);
                    if (loginSuccess) {
                        Toast.makeText(LogIn.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LogIn.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}

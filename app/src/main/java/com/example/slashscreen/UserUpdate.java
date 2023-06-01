package com.example.slashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        TextView chngepass = (TextView) findViewById(R.id.btnChangePassword);
        chngepass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UserUpdate.this, ChangePassword.class);
                startActivity(intent);
            }
        });

        TextView logout1 = (TextView) findViewById(R.id.textView3);
        logout1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UserUpdate.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView logout2 = (ImageView) findViewById(R.id.btnLogOut);
        logout2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UserUpdate.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
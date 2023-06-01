package com.example.slashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        TextView vidtext1 = (TextView) findViewById(R.id.click1);
        vidtext1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Video.this,Video1.class);
                startActivity(intent);
            }
        });
        TextView vidtext2 = (TextView) findViewById(R.id.click2);
        vidtext2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Video.this, Video2.class);
                startActivity(intent);
            }
        });

    }
}

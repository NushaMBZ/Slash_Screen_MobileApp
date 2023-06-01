package com.example.slashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // Set click listeners on location text and image
        TextView locatext = (TextView) findViewById(R.id.loctex1);
        locatext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Dashboard.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        ImageView locaimg = (ImageView) findViewById(R.id.locimg1);
        locaimg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Dashboard.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        ImageView userimg = (ImageView) findViewById(R.id.user);
        userimg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Dashboard.this, UserUpdate.class);
                startActivity(intent);
            }
        });
        TextView clcktext = (TextView) findViewById(R.id.clicktext);
        clcktext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Dashboard.this, Sensor.class);
                startActivity(intent);
            }
        });
        TextView textvid = (TextView) findViewById(R.id.vidtext);
        textvid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Dashboard.this,Video.class);
                startActivity(intent);
            }
        });
        ImageView imgvid = (ImageView) findViewById(R.id.vidimg);
        imgvid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Dashboard.this,Video.class);
                startActivity(intent);
            }
        });
    }
}

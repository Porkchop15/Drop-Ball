package com.example.dropballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, MusicService.class));
    }

    public void goToHome(View v){
        Intent i = new Intent(this, Home.class);
        startActivity(i);
        finish();
    }

    public void goToDevelopers(View v){
        Intent i = new Intent(this, Developers.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        finish();
    }


}

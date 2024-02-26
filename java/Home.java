package com.example.dropballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToDevelopers(View v){
        Intent i = new Intent(this, Developers.class);
        startActivity(i);
        finish();
    }

    public void goToInstructions(View v){
        Intent i = new Intent(this, Instructions.class);
        startActivity(i);
        finish();
    }

    public void goToGame(View v){
        Intent i = new Intent(this, Game.class);
        startActivity(i);
        finish();
    }
}

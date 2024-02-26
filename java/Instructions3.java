package com.example.dropballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Instructions3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions3);
    }

    public void goToInstructions2(View v){
        Intent i = new Intent(this, Instructions2.class);
        startActivity(i);
        finish();
    }

    public void goToGame(View v){
        Intent i = new Intent(this, Game.class);
        startActivity(i);
        finish();
    }
}

package com.example.dropballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Instructions4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions4);
    }
    public void goToInstructions3(View v){
        Intent i = new Intent(this, Instructions3.class);
        startActivity(i);
        finish();
    }

    public void goToInstructions5(View v){
        Intent i = new Intent(this, Instructions5.class);
        startActivity(i);
        finish();
    }
}

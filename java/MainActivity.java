package com.example.atry;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView[] boxes = new ImageView[6];
    private Button[] guessButtons = new Button[6];
    private Button startButton;

    private int ballPosition;
    private boolean animationInProgress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);

        // Initialize image views for boxes
        for (int i = 0; i < 6; i++) {
            int boxId = getResources().getIdentifier("box" + (i + 1), "id", getPackageName());
            boxes[i] = findViewById(boxId);
        }

        // Initialize guess buttons
        for (int i = 0; i < 6; i++) {
            int buttonId = getResources().getIdentifier("guessButton" + (i + 1), "id", getPackageName());
            guessButtons[i] = findViewById(buttonId);
        }
    }

    public void startGame(View view) {
        if (!animationInProgress) {
            // Reset UI and start the ball animation
            resetUI();
            animateBall();
        }
    }

    private void resetUI() {
        // Reset UI elements to their initial state
        for (ImageView box : boxes) {
            box.setBackgroundResource(R.drawable.box);
        }

        // Reset guess buttons
        for (Button button : guessButtons) {
            button.setSelected(false);
            button.setEnabled(true); // Enable the buttons
        }
    }

    private void animateBall() {
        // Simulate ball movement and set the final position
        Random random = new Random();
        ballPosition = random.nextInt(6);

        RotateAnimation rotate = new RotateAnimation(0, 360 * 5 + (60 * ballPosition),
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3000);
        rotate.setFillAfter(true);

        for (ImageView box : boxes) {
            box.startAnimation(rotate);
        }

        animationInProgress = true;

        // You can use animation or other methods to move the ball
        // For simplicity, let's just update the UI to show the result after a delay (e.g., 3 seconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showResult();
                animationInProgress = false;
            }
        }, rotate.getDuration());
    }

    private void showResult() {
        // Display the result only if the animation was in progress
        if (animationInProgress) {
            if (ballPosition >= 0 && ballPosition < 6) {
                boxes[ballPosition].setBackgroundResource(R.drawable.ball);

                int selectedButtonIndex = -1;

                // Check which guess button is selected
                for (int i = 0; i < 6; i++) {
                    if (guessButtons[i].isSelected()) {
                        selectedButtonIndex = i;
                        break;
                    }
                }

                // Check if the selected guess button matches the ball position
                if (selectedButtonIndex != -1 && selectedButtonIndex == ballPosition) {
                    // You win! Implement the winning logic (e.g., show a message)
                    Toast.makeText(MainActivity.this, "Congratulations! You guessed correctly!", Toast.LENGTH_SHORT).show();
                } else {
                    // Implement the logic for when the guessed position is incorrect
                    Toast.makeText(MainActivity.this, "Sorry! You guessed incorrectly.", Toast.LENGTH_SHORT).show();
                }

                // Enable all guess buttons after showing the result
                for (Button button : guessButtons) {
                    button.setEnabled(true);
                }
            }
        }
    }



    public void onGuessButtonClick(View view) {
        // Reset the state of all guess buttons
        for (Button button : guessButtons) {
            button.setSelected(false);
        }

        // Set the selected state for the clicked button
        view.setSelected(true);
    }
}

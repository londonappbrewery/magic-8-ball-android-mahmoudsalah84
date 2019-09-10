package com.londonappbrewery.magiceightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ballView = (ImageView) findViewById(R.id.ballImageView);
        final Button askButton = (Button) findViewById(R.id.Ask_button);

        final int[] callArray = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };


        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.d("8ball","Pressed Ask Button");

                int ballSelected = new Random().nextInt(5);

                Log.d("8ball","generated Random is " + ballSelected);

                ballView.setImageResource (callArray[ballSelected]);

            }
        });



    }
}


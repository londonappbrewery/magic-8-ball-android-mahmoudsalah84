package com.londonappbrewery.magiceightball;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int mPingSoundId;
    private SoundPool mSoundPool;

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

        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);



        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.d("8ball","Pressed Ask Button");

                int ballSelected = new Random().nextInt(5);

                Log.d("8ball","generated Random is " + ballSelected);

                ballView.setImageResource (callArray[ballSelected]);

                PlayPing();



            }
        });





    }

    public void PlayPing(){

        Log.d("8Ball","play sound");

        final int audioResId = mSoundPool.load(getApplicationContext(), R.raw.edsward_ping, 0);

        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int mySoundId, int status) {
                mSoundPool.play(audioResId, 1.0f, 1.0f, 0, 0, 1);
            }
        });



    }
}


package com.team7.sss.teleport;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FlashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen);


        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        //Animation
        ImageView myImageView = (ImageView) findViewById(R.id.logo);
        TextView myTextView = (TextView)findViewById(R.id.text);

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        myImageView.startAnimation(myFadeInAnimation);
        myTextView.startAnimation(myFadeInAnimation);


        //Start flash screen
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(FlashScreen.this, Bottom_Navigation.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }




    @Override
    //If the activity is opened again close it
    protected void onRestart()
    {
        super.onRestart();
        finish();
    }


}

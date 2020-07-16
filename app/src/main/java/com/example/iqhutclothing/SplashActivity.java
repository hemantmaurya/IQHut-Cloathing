package com.example.iqhutclothing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iqhutclothing.ui.home.HomeFragment;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    Animation topAmin, bottomAnim;
    ImageView image;
    TextView logo, slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        topAmin = AnimationUtils.loadAnimation( this, R.anim.top_animation_splash );
        bottomAnim = AnimationUtils.loadAnimation( this, R.anim.bottom_animation_splash );

//        hooks

        image = findViewById( R.id.imageView2 );
        logo = findViewById( R.id.textView3 );
        slogan = findViewById( R.id.textView4 );

        image.setAnimation( topAmin );
        logo.setAnimation( bottomAnim );
        slogan.setAnimation( bottomAnim );

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {

//                FragmentManager fm = getSupportFragmentManager();
//                HomeFragment fragment = new HomeFragment();
//                fm.beginTransaction().replace( R.id.container, fragment ).commit();

                Intent intent = new Intent( SplashActivity.this, LoginActivity.class );

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image, "logo_image");
                pairs[1] = new Pair<View,String>(logo, "logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( SplashActivity.this, pairs );
                startActivity( intent, options.toBundle() );
                finish();


            }
        }, SPLASH_SCREEN );




    }
}
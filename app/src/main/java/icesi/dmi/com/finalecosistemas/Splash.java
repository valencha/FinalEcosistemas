package icesi.dmi.com.finalecosistemas;


import android.app.Activity;
import android.content.Intent;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Splash extends Activity {

    pl.droidsonroids.gif.GifImageView imge2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imge2= findViewById(R.id.imageView2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

            }
        }, 5000);



    }
}

package ics.raghav.verticalhomes;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ics.raghav.verticalhomes.LoginAndReg.Login_Activity;

public class Splash_Activity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent i=new Intent(Splash_Activity.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        },2000);

    }
}

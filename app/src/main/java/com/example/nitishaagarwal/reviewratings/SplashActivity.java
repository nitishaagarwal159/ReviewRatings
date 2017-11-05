package com.example.nitishaagarwal.reviewratings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String app,api,li;
        SharedPreferences sp=getSharedPreferences("main", Context.MODE_PRIVATE);
        app=sp.getString("software",null);
        api=sp.getString("api_key",null);
        li = sp.getString("list",null);
       /* Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {*/
                if (app == null) {
                    Intent intent = new Intent(SplashActivity.this, ChooseAccountActivity.class);
                    startActivity(intent);
                    finish();
                } else if (api == null) {
                    Log.d("codekamp","hi"+app);
                    Intent intent = new Intent(SplashActivity.this, MailChimpEnterKey.class);
                    startActivity(intent);
                    finish();
                }
                else
               /* if(li==null)*/
                {
                  //  SharedPreferences sp=getSharedPreferences("main",Context.MODE_PRIVATE);
                    Intent intent = new Intent(SplashActivity.this, ListChooseActivity.class);
                    startActivity(intent);
                    /*SharedPreferences sp=getSharedPreferences("main",Context.MODE_PRIVATE);
                    Log.d("codekamp",""+sp.getString("api_key",null));*/
                    finish();
                }
               /* else
                {
                    Intent intent = new Intent(SplashActivity.this,Review.class);
                    startActivity(intent);
                    finish();
                }*/
            }
       //}, 5000);
    //}
}

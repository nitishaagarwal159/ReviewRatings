package com.example.nitishaagarwal.reviewratings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChooseAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);
    }
    public void appselected(View v)
    {
         String button_text;
        SharedPreferences sp = getSharedPreferences("main", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        button_text = ((Button)v).getText().toString();
        e.putString("software",button_text);
        e.commit();
        if(button_text.equals("MailChimp"))
        {
            Intent intent = new Intent(this, MailChimpEnterKey.class);
            startActivity(intent);
        }
        else
        {
            //to be done same like mail chimp
            Log.d("codekamp","ConstantContact Selected");
        }
    }
}

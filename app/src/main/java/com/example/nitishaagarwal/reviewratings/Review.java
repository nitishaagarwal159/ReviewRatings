package com.example.nitishaagarwal.reviewratings;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Callback;

public class Review extends AppCompatActivity {

    EditText n,e;
    Button b;
    SharedPrefs sp =new SharedPrefs();
    String id = sp.getlistid();
    HashMap<String,String> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        n=(EditText)findViewById(R.id.name);
        e=(EditText)findViewById(R.id.email);
        b=(Button)findViewById(R.id.done);
        // String name=n.getText().toString();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e.getText().toString();
                String name = n.getText().toString();
                email=email.trim();
                name=name.trim();
                String msg = null;
                int p=1;
                if (name.equals("") && email.equals("")) {
                    p=0;
                    msg="Enter your e-mail address and name";
                }
                else if(name.equals(""))
                {
                    p=0;
                    msg="Enter your name";
                }
                else
                    if(email.equals(""))
                {
                    p=0;
                    msg="Enter your e-mail address";
                }
                 if(p==0)
                 {
                     AlertDialog ad = new AlertDialog.Builder(Review.this).create();
                     ad.setTitle("Warning");
                     ad.setMessage(""+msg);
                     ad.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     });
                     ad.show();
                 }
                else
                {
                    //or u can make class having members email and status
                    map.put("email_address", email);
                    map.put("status", "subscribed");
                    Log.d("codekamp", email);
                    MailchimpServiceBuilder.build().addcontact(id, map).enqueue(new ResponseCallback<AddContacts>() {
                        @Override
                        public void onSuccess(AddContacts response) {
                            Log.d("codekamp", "Contact added successfully");
                        }

                        @Override
                        public void onError(ApiError error) {
                            Log.d("codekamp", error.message);
                        }
                    });

                    Intent i = new Intent(Review.this, LastActivity.class);
                    startActivity(i);
                    n.setText(" ");
                    e.setText(" ");
                }
            }
        });
    }
}

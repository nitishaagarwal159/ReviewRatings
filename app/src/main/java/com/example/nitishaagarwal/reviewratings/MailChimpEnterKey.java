package com.example.nitishaagarwal.reviewratings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MailChimpEnterKey extends Activity {

   public static String API = null;
    //public static final String key="qwert";
    String s;
    int l;
    EditText editText;

   // public static String MAILCHIMP_BASE_URL = null;//"https://us16.api.mailchimp.com/3.0/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_chimp_enter_key);
        editText=(EditText)findViewById(R.id.et);
        editText.setText(" ");
        Log.d("codekamp","hello");
    }
    public void done(View v)
    {
        API=editText.getText().toString();
        API=API.trim();
        Log.d("codekamp", "this is" + API);
        if(API.equals(null)||API.equals(""))
        {
            Log.d("codekamp","Empty");
            Toast.makeText(this,"Please Enter API key",Toast.LENGTH_SHORT).show();
        }
        else
        {
            SharedPrefs.setApiKey(API);
            Log.d("codekamp", "how" + API);
       /* SharedPreferences sp = (MyApplication.getAppContext()).getSharedPreferences("main",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("api_key",API_KEY);
        Log.d("codekamp",""+API_KEY);
        editor.commit();*/
            Intent intent = new Intent(this, ListChooseActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

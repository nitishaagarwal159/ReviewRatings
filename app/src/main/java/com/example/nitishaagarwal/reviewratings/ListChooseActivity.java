package com.example.nitishaagarwal.reviewratings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListChooseActivity extends AppCompatActivity
{
   /* public static String API_KEY=null;
    public static String MAILCHIMP_BASE_URL=null;*/
    RecyclerView rv ;
    Context c;
    LinearLayout  p,t;
    TextView terr;
    Activity con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_choose);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        c=this;
        p=(LinearLayout) findViewById(R.id.progress);
        t=(LinearLayout)findViewById(R.id.err);
        terr=(TextView)findViewById(R.id.terr);
        p.setVisibility(View.VISIBLE);
        SharedPreferences sp=getSharedPreferences("main", Context.MODE_PRIVATE);
        String api=sp.getString("api_key",null);
        Log.d("codekamp",api);
        con=this;
        /*MailchimpServiceBuilder.build().getAllLists("bearer " + API_KEY).enqueue(new Callback<AllListsResponse>() {
            @Override
            public void onResponse(Call<AllListsResponse> call, Response<AllListsResponse> response) {
                //  scheduleDismiss();
                //view.setVisibility(View.GONE);
                //      spinner.setVisibility(View.GONE);
                Log.d("codekamp",""+"hello");
                Log.d("codekamp", String.valueOf(response.body().listsCount));
                Log.d("codekamp",response.body().lists.get(2).title);
                //  try {
                //    Log.d("codekamp", response.raw().body().string());
                //} catch (IOException e) {
                //   e.printStackTrace();
                //}
                recyadapter adapter= new recyadapter(c,response);
                rv.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<AllListsResponse> call, Throwable t) {
                Log.d("codekamp", "Fail");
            }
        });


        Log.d("codekamp", "onCreate complete");
    }*/
        MailchimpServiceBuilder.build().getAllLists().enqueue(new ResponseCallback<AllListsResponse>() {


            @Override
            public void onSuccess(AllListsResponse response) {
                Log.d("codekamp", "onSuccess called");
                Log.d("codekamp", response.lists.get(0).title);
                recyadapter adapter= new recyadapter(c,response);
                adapter.co=con;//can not do adapter.co=this because this here would assign this of anonymous class i.e. object of all lists response
                rv.setAdapter(adapter);
                p.setVisibility(View.GONE);
            }

            @Override
            public void onError(ApiError error)
            {
                Log.d("codekamp", "onError called");
                Log.d("codekamp", error.message);
                SharedPrefs.setApiKey(null);
                p.setVisibility(View.GONE);
                t.setVisibility(View.VISIBLE);
                terr.setText("Error "+error.status+"  "+error.message);

            }
        });
            Log.d("codekamp", "onCreate complete");
        }

  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
//call whenever user clicks on item
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        SharedPrefs.setApiKey(null);
        Intent i = new Intent(this,MailChimpEnterKey.class);
        startActivity(i);
        finish();
        return super.onOptionsItemSelected(item);
    }
}

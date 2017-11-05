package com.example.nitishaagarwal.reviewratings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Nitisha Agarwal on 17-09-2017.
 */

public class RecyViewHolder extends RecyclerView.ViewHolder{
    TextView t;
    Activity context;
    HashMap map=new HashMap();
    public RecyViewHolder(View itemView,Activity c,HashMap ma) {
        super(itemView);
        t=(TextView)itemView.findViewById(R.id.id1);
        this.context=c;
        this.map=ma;
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SharedPreferences sp = MyApplication.getAppContext().getSharedPreferences("main", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("list",t.getText().toString());
                editor.putString("list_id",(String)map.get(t.getText().toString()));
                editor.commit();
                Log.d("codekamp",""+t.getText().toString());
                Log.d("codekamp",sp.getString("list_id",null));
                Intent intent=new Intent(context,Review.class);
                context.startActivity(intent);
            }
        });
    }
}

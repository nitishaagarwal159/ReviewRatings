package com.example.nitishaagarwal.reviewratings;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

import retrofit2.Response;

/**
 * Created by Nitisha Agarwal on 17-09-2017.
 */

public class recyadapter extends RecyclerView.Adapter<RecyViewHolder> {
    Context context;
     AllListsResponse re;
    Activity co;
    HashMap m=new HashMap();

    public recyadapter(Context c,AllListsResponse response)
    {
        this.context = c;
        re=response;
    }
    @Override
    public RecyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_layout,parent,false);
        return new RecyViewHolder(view,co,m);
    }

    @Override
    public void onBindViewHolder(RecyViewHolder holder, int position)
    {
        m.put(re.lists.get(position).title,re.lists.get(position).id);

        holder.t.setText("" + re.lists.get(position).title);
    }

    @Override
    public int getItemCount() {
        return re.listsCount;
    }
}

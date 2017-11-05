package com.example.nitishaagarwal.reviewratings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Nitisha Agarwal on 17-09-2017.
 */

public class AllListsResponse {
    @Expose
    @SerializedName("total_items")
    public int listsCount;
    @Expose
    @SerializedName("lists")
    public ArrayList<MailchimpList> lists;
}

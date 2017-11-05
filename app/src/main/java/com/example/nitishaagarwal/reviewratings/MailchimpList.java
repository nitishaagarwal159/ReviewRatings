package com.example.nitishaagarwal.reviewratings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nitisha Agarwal on 17-09-2017.
 */

public class MailchimpList {
    @Expose
    @SerializedName("id")
    public String id;
    @Expose
    @SerializedName("name")
    public String title;
}


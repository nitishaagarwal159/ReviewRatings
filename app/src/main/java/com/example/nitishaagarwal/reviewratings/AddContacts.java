package com.example.nitishaagarwal.reviewratings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nitisha Agarwal on 23-09-2017.
 */

public class AddContacts {
    @Expose
    @SerializedName("email_address")
    public String email;
    @Expose
    @SerializedName("status")
    public String status;
}

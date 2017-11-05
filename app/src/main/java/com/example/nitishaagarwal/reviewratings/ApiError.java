package com.example.nitishaagarwal.reviewratings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nitisha Agarwal on 18-09-2017.
 */

public class ApiError {
    @Expose
         @SerializedName("title")
         public String message;
    @Expose
    @SerializedName("status")
         public int status;
    public ApiError(String message, int status) {
                 this.message = message;
                 this.status = status;
             }
}

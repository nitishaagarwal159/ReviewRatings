package com.example.nitishaagarwal.reviewratings;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Nitisha Agarwal on 17-09-2017.
 */

public interface MailchimpService {
    @GET("lists")
    Call<AllListsResponse> getAllLists();
    // GET request on baseURl/lists?count=<a>&offset=<b>
   //@GET("/lists/{xyz}/{members}")
  //  Call<AllContactsResponse> getContacts(@Header("Authorization") String auth, @Path("members") String listId, @Query("hello") float a,
                                          //@Path("xyz") int something);
    @POST("lists/{list_id}/members")
    Call<AddContacts> addcontact(@Path("list_id") String id , @Body HashMap<String,String> map);
}

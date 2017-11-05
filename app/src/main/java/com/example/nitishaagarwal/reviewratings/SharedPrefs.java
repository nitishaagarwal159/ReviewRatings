package com.example.nitishaagarwal.reviewratings;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nitisha Agarwal on 18-09-2017.
 */

public class SharedPrefs {
    private static final String API_KEY = "api_key";
    private static SharedPreferences getPrefrences() {
                 Context c = MyApplication.getAppContext();
                 return c.getSharedPreferences("main", Context.MODE_PRIVATE);
             }
    public static void setApiKey(String apiKey) {
                 getPrefrences().edit().putString(API_KEY, apiKey).commit();
             }
    public static String getApiKey() {
                 return getPrefrences().getString(API_KEY, null);
             }
    public static String getlistid() { return getPrefrences().getString("list_id",null);}
}

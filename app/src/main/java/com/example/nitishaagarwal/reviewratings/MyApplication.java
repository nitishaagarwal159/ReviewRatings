package com.example.nitishaagarwal.reviewratings;

import android.app.Application;
import android.content.Context;

/**
 * Created by Nitisha Agarwal on 18-09-2017.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getAppContext() {
        return context;
    }
}

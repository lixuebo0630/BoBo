package com.lixuebo.bobo;

import android.app.Application;
import android.content.Context;

/**
 * Created by lixuebo on 17/3/2.
 */

public class MyApplication extends Application {


    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
}

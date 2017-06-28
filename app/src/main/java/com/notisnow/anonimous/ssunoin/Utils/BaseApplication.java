package com.notisnow.anonimous.ssunoin.Utils;

import android.app.Application;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class BaseApplication extends Application{

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        connectInitializer();
    }
    private void connectInitializer(){
        Log.d("in BaseApplication","init");
        requestQueue= Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
}

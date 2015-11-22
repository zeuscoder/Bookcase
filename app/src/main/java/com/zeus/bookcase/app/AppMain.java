package com.zeus.bookcase.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.zeus.bookcase.BuildConfig;

import timber.log.Timber;

/**
 * Created by zeus_coder on 2015/9/30.
 */
public class AppMain extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

/*        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }*/
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}

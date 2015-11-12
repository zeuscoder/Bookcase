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

    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;

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
        initTypeface();
    }

    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(), CANARO_EXTRA_BOLD_PATH);

    }
}

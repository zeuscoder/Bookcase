package com.zeus.skeleton.bean;

import android.util.Log;

/**
 * Created by zeus_coder on 2015/10/4.
 */
public class Heater {

    private boolean isHot;

    public void on() {
        Log.d("dagger","start");
        isHot = true;
    }

    public void off() {
        Log.d("dagger","stop");
        isHot = false;
    }

    public boolean isHot() {
        return isHot;
    }
}

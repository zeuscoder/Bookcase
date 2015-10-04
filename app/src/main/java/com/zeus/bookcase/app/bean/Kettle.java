package com.zeus.bookcase.app.bean;

import android.util.Log;

import com.zeus.skeleton.bean.Heater;

import javax.inject.Inject;

/**
 * Created by zeus_coder on 2015/10/4.
 */
public class Kettle {

    private Heater heater;

    @Inject
    public Kettle(Heater heater) {
        super();
        this.heater = heater;
    }

    public void on() {
        heater.on();
    }

    public void off() {
        heater.off();
    }

    public void brew() {
        if(heater.isHot()) {
            Log.d("dagger","pull");
        }
    }
}

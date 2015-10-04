package com.zeus.bookcase.app.module;

import com.zeus.bookcase.app.bean.Kettle;
import com.zeus.skeleton.bean.Heater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zeus_coder on 2015/10/4.
 */
@Module
public class KettleModule {

    @Singleton
    @Provides
    Heater providesHeater() {
        return new Heater();
    }

    @Singleton
    @Provides
    Kettle providesKettle(Heater heater) {
        return new Kettle(heater);
    }
}

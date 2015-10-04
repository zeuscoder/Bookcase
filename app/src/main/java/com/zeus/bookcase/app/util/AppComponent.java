package com.zeus.bookcase.app.util;

import com.zeus.bookcase.app.bean.Kettle;
import com.zeus.bookcase.app.module.KettleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zeus_coder on 2015/10/4.
 */
@Singleton
@Component(modules = KettleModule.class)
public interface AppComponent {
    Kettle providesKettle();
}

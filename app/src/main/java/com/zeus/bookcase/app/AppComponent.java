package com.zeus.bookcase.app;

import com.zeus.skeleton.Skeleton;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zeus_coder on 2015/10/8.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent extends Skeleton.Component {
}

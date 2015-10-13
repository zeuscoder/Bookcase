package com.zeus.skeleton;

import android.app.Application;

import com.zeus.skeleton.app.AppNavigator;

import dagger.Module;

/**
 * 单例模式-Skeleton框架
 * Created by zeus_coder on 2015/10/4.
 */
public class Skeleton {

    private static Skeleton skeleton;

    public static void initialize() {

    }

    public interface Component {
/*        Application app();

        AppNavigator appNavigator();*/
    }

    @dagger.Module
    public static  class Module {

/*        private final Application application;

        public Module(Application application) {
            this.application = application;
        }*/

    }

}

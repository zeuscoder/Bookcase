package com.zeus.skeleton;

import android.app.Application;

import com.zeus.skeleton.app.AppNavigator;

import java.util.IllegalFormatException;

import dagger.Module;
import dagger.Provides;

/**
 * 单例模式-Skeleton框架
 * Created by zeus_coder on 2015/10/4.
 */
public class Skeleton {

    private static Skeleton skeleton;

    public static void initialize(Component component) {
        if(skeleton != null) {
            throw new IllegalStateException("has initialize");
        }
        skeleton = new Skeleton(component);
    }

    private static Skeleton instance() {
        if(skeleton == null) {
            throw new IllegalStateException("skeleton not initialized");
        }
        return skeleton;
    }

    private final Component component;

    private Skeleton(Component component) {
        this.component = component;
    }

    public static Component component() {
        return instance().component;
    }

    /**
     * 用于访问 component 实现的其他接口
     */
    public static <C> C component(Class<C> cls) {
        return cls.cast(component());
    }

    public static Application app() {
        return component().app();
    }

    public interface Component {
        Application app();

       /* AppNavigator appNavigator();*/
    }

    @dagger.Module
    public static  class Module {

        private final Application application;

        public Module(Application application) {
            this.application = application;
        }

        @Provides
        Application providesApplication() {
            return  application;
        }

    }

}

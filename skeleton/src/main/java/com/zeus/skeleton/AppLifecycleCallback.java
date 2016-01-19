package com.zeus.skeleton;

import android.app.Application;

/**
 * 应用生命周期的回调
 * Created by zeus_coder on 2016/1/19.
 */
public interface AppLifecycleCallback {

    /**
     * 应用初始化
     * @param app 应用对象
     * @param inMainProcess 当前是否在主进程
     */
    void initialize(Application app, boolean inMainProcess);

    /**
     * 应用退出
     * @param app 应用对象
     * @param inMainProcess 当前是否在主进程
     */
    void shutdown(Application app, boolean inMainProcess);
}

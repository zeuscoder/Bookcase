package com.zeus.bookcase.app.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zeus.skeleton.Skeleton;

/**
 * Created by zeus_coder on 2015/10/18.
 */
public class AppPrefs {

    private static final String PREF_NAME = "app";

    private static final String KEY_LAST_RUNNING_VERSION = "last_running_version";

    private static final String KEY_LAST_SHOWN_INTRO_VERSION = "last_shown_intro_version";

    private static AppPrefs instance = null;

    public static synchronized AppPrefs getInstance() {
        if(instance == null) {
            instance = new AppPrefs(Skeleton.app());
        }
        return instance;
    }

    private final SharedPreferences prefs;

    private AppPrefs(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, 0);
    }

    private String buildRunningVersion(String versionName, int versionCode) {
        return versionCode + "=" + versionName;
    }

    /**
     * 更新记录的运行版本
     *
     * @param versionName 版本名
     * @param versionCode 版本编号
     * @return 是否发生了变更
     */
    public boolean updateRunningVersion(String versionName, int versionCode) {
        String runningVersion = buildRunningVersion(versionName, versionCode);
        String lastRunningVersion = prefs.getString(KEY_LAST_RUNNING_VERSION, null);
        if (TextUtils.equals(lastRunningVersion, runningVersion)) {
            return false;
        }
        prefs.edit().putString(KEY_LAST_RUNNING_VERSION, runningVersion).apply();
        return true;
    }

    /**
     * 是否展示过给定版本的引导页内容
     * @param version
     * @return
     */
    public boolean hasIntroShown(String version) {
        return TextUtils.equals(version, prefs.getString(KEY_LAST_SHOWN_INTRO_VERSION, null));
    }

    /**
     * 保存展示过的引导页的版本号
     * @param version
     */
    public void updateIntroShownVersion(String version) {
        prefs.edit().putString(KEY_LAST_SHOWN_INTRO_VERSION, version).apply();
    }
}

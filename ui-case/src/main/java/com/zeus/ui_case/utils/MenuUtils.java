package com.zeus.ui_case.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by zeus_coder on 2016/1/27.
 */
public class MenuUtils {

    private MenuUtils() {}

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}

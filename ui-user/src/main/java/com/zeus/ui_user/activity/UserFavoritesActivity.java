package com.zeus.ui_user.activity;

import android.app.Activity;
import android.os.Bundle;

import com.zeus.ui_user.R;

/**
 * Created by zeus_coder on 2016/1/10.
 */
public class UserFavoritesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_favorites);
        initTopButton(R.string.activity_favorites,R.mipmap.user_arrow_back, 0);
    }
}

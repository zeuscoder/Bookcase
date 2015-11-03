package com.zeus.ui_user.activity;

import android.app.Activity;
import android.os.Bundle;

import com.zeus.ui_user.R;

/**
 * Created by zeus_coder on 2015/11/1.
 */
public class MySelfActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user__fragment_myself);
        initTopButton(R.string.user_myself, 0,0);
    }
}

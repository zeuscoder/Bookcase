package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeus.bookcase.R;

/**
 * Created by zeus_coder on 2015/11/20.
 */
public class BaseActivity extends Activity {

    protected ImageView btn_left;
    protected TextView tv_title;
    protected TextView btn_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initTopButton(int titleId, int leftImgId, int rightStrId) {
        tv_title = (TextView) findViewById(R.id.topbar_title);
        tv_title.setText(this.getString(titleId));
        btn_left = (ImageView) findViewById(R.id.leftBtn);
        btn_right = (TextView) findViewById(R.id.rightBtn);
        if(leftImgId == 0) {
            btn_left.setVisibility(View.GONE);
        } else {
            btn_left.setVisibility(View.VISIBLE);
            btn_left.setImageResource(leftImgId);
            btn_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}

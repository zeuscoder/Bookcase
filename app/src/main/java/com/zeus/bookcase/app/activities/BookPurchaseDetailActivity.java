package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.os.Bundle;

import com.zeus.bookcase.R;

/**
 * Created by zeus_coder on 2015/12/29.
 */
public class BookPurchaseDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_purchase_detail);
        initTopButton(R.string.app_name, 0, 0);
    }
}

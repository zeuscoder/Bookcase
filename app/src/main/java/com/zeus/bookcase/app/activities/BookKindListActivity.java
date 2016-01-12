package com.zeus.bookcase.app.activities;

import android.os.Bundle;

import com.zeus.bookcase.R;

/**
 * Created by zeus_coder on 2016/1/10.
 */
public class BookKindListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_book_kind_list);
        initTopButton(R.string.activity_book_kind_list, R.mipmap.app_arrow_back, 0);
    }
}

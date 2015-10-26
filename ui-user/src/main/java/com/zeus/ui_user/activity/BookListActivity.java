package com.zeus.ui_user.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.yalantis.phoenix.PullToRefreshView;
import com.zeus.ui_user.R;
import com.zeus.ui_user.adapter.BookListViewAdapter;

import java.util.List;

/**
 * Created by zeus_coder on 2015/10/25.
 */
public class BookListActivity extends Activity {

    private PullToRefreshView pullToRefreshView;
    private ListView bookList;
    private List<String> list;
    private BookListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user__book_list);
        initView();
        setData();
    }

    private void initView() {

    }

    private void setData() {

    }
}

package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.os.Bundle;

import com.yalantis.phoenix.PullToRefreshView;
import com.zeus.bookcase.R;

/**
 * Created by zeus_coder on 2015/10/6.
 */
public class PullRefreshActivity extends Activity {

    private PullToRefreshView mPullToRefreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_refresh);

        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 5000);
            }
        });
    }
}

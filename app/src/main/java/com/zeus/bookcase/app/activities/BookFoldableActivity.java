package com.zeus.bookcase.app.activities;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.yalantis.phoenix.PullToRefreshView;
import com.zeus.bookcase.R;
import com.zeus.bookcase.app.adpter.FoldablePhotoAdapter;


import java.io.IOException;

/**
 * Created by zeus_coder on 2015/11/20.
 */
public class BookFoldableActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private PullToRefreshView mPullToRefreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__book_show_list);
        initTopButton(R.string.app_name, 0, 0);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        //填充假数据-->FoldableAssetProvider
        String[] dataSet = null;
        try {
            dataSet = getAssets().list("demo-pictures");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TestTest","TestTest");
        }
        FoldablePhotoAdapter adapter = new FoldablePhotoAdapter(dataSet, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}

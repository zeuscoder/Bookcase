package com.zeus.ui_user.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zeus.ui_user.R;
import com.zeus.ui_user.adapter.ExpressTimeLineAdapter;
import com.zeus.ui_user.model.ExpressTimeLineModel;
import com.zeus.ui_user.view.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeus_coder on 2015/12/26.
 */
public class ExpressTimeLineActivity extends BaseActivity {

    private RecyclerView expressRecyclerView;

    private ExpressTimeLineAdapter expressTimeLineAdapter;

    private List<ExpressTimeLineModel> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_express_timeline);
        initTopButton(R.string.activity_express, R.mipmap.user_arrow_back, 0);

        expressRecyclerView = (RecyclerView) findViewById(R.id.label_express_timeline);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        expressRecyclerView.setLayoutManager(new FullyLinearLayoutManager(ExpressTimeLineActivity.this));
        expressRecyclerView.setFocusable(false);
        initView();
    }

    private void initView() {
        for(int i = 0; i < 10; i++) {
            ExpressTimeLineModel model = new ExpressTimeLineModel();
            model.setThing("【广州市】广州天河东圃公司神舟分部进行签收扫描，快件已被收发室签收，感谢使用顺丰快递，期待再次为您服务。");
            model.setTime("2016-1-6 10:57:35");
            mDataList.add(model);
        }
        expressTimeLineAdapter = new ExpressTimeLineAdapter(mDataList);
        expressRecyclerView.setAdapter(expressTimeLineAdapter);
    }

}

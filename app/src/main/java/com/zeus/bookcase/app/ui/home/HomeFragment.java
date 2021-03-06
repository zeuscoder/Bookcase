package com.zeus.bookcase.app.ui.home;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.activities.BookFoldableActivity;
import com.zeus.bookcase.app.activities.BookLoadingActivity;
import com.zeus.bookcase.app.activities.PreferenceWebActivity;
import com.zeus.bookcase.app.adpter.LabelRecommendBookListAdapter;
import com.zeus.bookcase.app.adpter.LabelRecommendGeekListAdapter;
import com.zeus.bookcase.app.model.Geek;
import com.zeus.common.widget.NonScrollingGridView;
import com.zeus.ui_user.activity.BookListActivity;

import java.util.ArrayList;
import java.util.List;

import static com.zeus.bookcase.R.id.label_recommend_book_list;


/**
 * Created by zeus_coder on 2015/11/5.
 */
public class HomeFragment extends Fragment {

    private ImageView centerimagview;
    private ImageView loadimageview;
    private ImageView showImageView;
    private ListView labelRecommendBookList;
    private NonScrollingGridView labelRecommendGeekList;

    private List<Geek> geeks = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*这里有问题*/
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        initView(view);
        initBookList(view);
        initGeekList(view);


        centerimagview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PreferenceWebActivity.class));
            }
        });
        loadimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), BookLoadingActivity.class));
                startActivity(new Intent(getActivity(), BookFoldableActivity.class));
            }
        });
        showImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookListActivity.class));
            }
        });
    }

    private void initView(View view) {
        centerimagview = (ImageView) view.findViewById(R.id.centerimagview);
        loadimageview = (ImageView) view.findViewById(R.id.book_loading);
        showImageView = (ImageView) view.findViewById(R.id.book_show);
    }

    private void initGeekList(View view) {
        int[] photos = { R.mipmap.app_home_geek_photo,
                R.mipmap.app_home_geek_photo2,
                R.mipmap.app_home_geek_photo3,
                R.mipmap.app_home_geek_photo4,
                R.mipmap.app_home_geek_photo5,
                R.mipmap.app_home_geek_photo6 };
        for(int i = 0;i < 6;i++) {
            Geek geek = new Geek();
            geek.setName("Zeus" + i);
            geek.setTitle("帅气达人" + i);
            geek.setPhoto(photos[i]);
            geeks.add(geek);
        }
        labelRecommendGeekList = (NonScrollingGridView) view.findViewById(R.id.label_recommend_geek_list);
        labelRecommendGeekList.setAdapter(new LabelRecommendGeekListAdapter(getActivity(),geeks));
    }

    private void initBookList(View view) {
        labelRecommendBookList = (ListView) view.findViewById(label_recommend_book_list);
        labelRecommendBookList.setAdapter(new LabelRecommendBookListAdapter(getActivity()));
        //解决listview在嵌套下只显示一行的问题
        setListViewHeightBasedOnChildren(labelRecommendBookList);
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if(listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for(int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
}

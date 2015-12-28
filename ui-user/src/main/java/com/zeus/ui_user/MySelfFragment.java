package com.zeus.ui_user;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zeus.common.tabs.MaterialTab;
import com.zeus.common.tabs.MaterialTabHost;
import com.zeus.common.tabs.MaterialTabListener;
import com.zeus.common.widget.NonScrollingGridView;
import com.zeus.ui_user.activity.BookCollectionTabActivity;
import com.zeus.ui_user.activity.BookListLabelActivity;
import com.zeus.ui_user.adapter.UserFunctionAdapter;
import com.zeus.ui_user.fragment.FirstFragment;
import com.zeus.ui_user.model.Function;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by zeus_coder on 2015/10/31.
 */
public class MySelfFragment extends Fragment implements View.OnClickListener,MaterialTabListener {

    private Button btn;

    private ViewPager pager;
    //private ViewPagerAdapter pagerAdapter;
    private MaterialTabHost tabHost;
    private Resources res;
    private CircleImageView photo;
    private NonScrollingGridView functionGridView;

    private List<Function> functions = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        //fillView();
    }

    private void initUI(View view) {
        btn = (Button) view.findViewById(R.id.btnFollow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookCollectionTabActivity.class));
            }
        });

        photo = (CircleImageView) view.findViewById(R.id.user_profile_photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookListLabelActivity.class));
            }
        });

        int[] icons = { R.mipmap.user_function_item1,
                R.mipmap.user_function_item2,
                R.mipmap.user_function_item3,
                R.mipmap.user_function_item4,
                R.mipmap.user_function_item5,
                R.mipmap.user_function_item6,
                R.mipmap.user_function_item7,
                R.mipmap.user_function_item8 };
        for(int i = 0;i < 8;i++) {
            Function function = new Function();
            function.setName("收藏夹" + i);
            function.setTitle("帅气达人" + i);
            function.setIcon(icons[i]);
            functions.add(function);
        }
        functionGridView = (NonScrollingGridView) view.findViewById(R.id.user_function_list);
        functionGridView.setAdapter(new UserFunctionAdapter(getActivity(), functions));


        //res = view.getResources();
        // init toolbar (old action bar)

        //tabHost = (MaterialTabHost) view.findViewById(R.id.tabHost);
        //pager = (ViewPager) view.findViewById(R.id.pager);
        // init view pager   getChildFragmentManager会报错
 /*       pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });
        // insert all tabs from pagerAdapter data
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setText(pagerAdapter.getPageTitle(i))
                            .setTabListener(this)
            );
        }*/

        /*调试用的，可以删掉*/
/*        tabHost.addTab(
                tabHost.newTab()
                        .setText((CharSequence)"hjk")
                        .setTabListener(this)
        );
        tabHost.addTab(
                tabHost.newTab()
                        .setText((CharSequence)"dah")
                        .setTabListener(this)
        );
        tabHost.addTab(
                tabHost.newTab()
                        .setText((CharSequence)"dsah")
                        .setTabListener(this)
        );*/
    }

/*    private void fillView() {
        initTopBar(R.string.user_myself, 0);
    }*/

/*    private void initTopBar(int titleId, int rightStrId) {
        if(getView() == null) {
            return;
        }
        ((TextView)getView().findViewById(R.id.topbar_title)).setText(this.getString(titleId));
        getView().findViewById(R.id.leftBtn).setVisibility(View.GONE);
        TextView btnRight = (TextView)getView().findViewById(R.id.rightBtn);
        if(rightStrId == 0) {
            btnRight.setVisibility(View.GONE);
        } else {
            btnRight.setVisibility(View.VISIBLE);
            btnRight.setText(getResources().getString(rightStrId));
        }
    }*/

    @Override
    public void onTabSelected(MaterialTab tab) {
        // when the tab is clicked the pager swipe content to the tab position
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

/*    private class ViewPagerAdapter extends FragmentPagerAdapter {

*//*        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }*//*

        public android.support.v4.app.Fragment getItem(int num) {
            return new FirstFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "订单";
                case 1:
                    return "购物车";
                case 2:
                    return "收藏夹";
                default:
                    return null;
            }
        }
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {

    }
}

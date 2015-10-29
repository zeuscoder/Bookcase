package com.zeus.bookcase.app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.data.prefs.AppPrefs;
import com.zeus.skeleton.app.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 *
 * Created by zeus_coder on 2015/10/16.
 */
public class IntroActivity extends BaseActivity{

    /**
     * 引导页内容的版本号, 以日期为版本
     */
    private static final String CURRENT_INTRO_VERSION = "20151018";

    // type: Intent
    private static final String EXTRA_NEXT_ACTIVITY_INTENT = "app:next-activity-intent";

    int[] imgIds = {
            R.drawable.app__intro_01,
            R.drawable.app__intro_02,
            R.drawable.app__intro_03
    };

    private ViewPager vp;
    private List<View> views;
    //记录当前位置
    private int currentIndex = 0;
    private boolean misScrolled;

    public static Intent actionView(Context context, Intent activityIntent) {
        if (activityIntent == null) {
            //只进入导航页
            return new Intent(context, IntroActivity.class);
        }
        if (AppPrefs.getInstance().hasIntroShown(CURRENT_INTRO_VERSION)) {
            // 导航页已经展示过了, 直接跳转到目标页面
            return activityIntent;
        }
        return new Intent(context,IntroActivity.class)
                .putExtra(EXTRA_NEXT_ACTIVITY_INTENT,activityIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_intro);
        initViews();
    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        //初始化引导图片列表
        for (int imgId:imgIds) {
            RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.app__intro_item, null);
            ImageView image = (ImageView) view.findViewById(R.id.intro_img);
            image.setImageResource(imgId);
            views.add(view);
        }
        //初始化Adapter
        MyPagerAdapter adapter = new MyPagerAdapter(views);
        vp = (ViewPager) findViewById(R.id.viewPager);
        vp.setAdapter(adapter);
        // 绑定回调
        vp.setCurrentItem(currentIndex);
//        vp.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    private void finishIntro() {
        AppPrefs.getInstance().updateIntroShownVersion(CURRENT_INTRO_VERSION);
        Intent nextActivityIntent = getIntent().getParcelableExtra(EXTRA_NEXT_ACTIVITY_INTENT);
        if (nextActivityIntent != null) {
            startActivity(nextActivityIntent);
        }
        finish();
    }

    @Override
    public void onBackPressed() {

    }

    /**
     * viewPage 适配器
     */
    class MyPagerAdapter extends PagerAdapter {

        private List<View> views;

        public MyPagerAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object object) {
            ((ViewPager) arg0).removeView(views.get(arg1));
        }

        @Override
        public int getCount() {
            if (views != null)
            {
                return views.size();
            }

            return 0;
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(views.get(arg1), 0);
            return views.get(arg1);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Parcelable saveState() {
            return null;
        }
    }

    /**
     * 页卡切换监听
     */
    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_DRAGGING:
                    misScrolled = false;
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    misScrolled = true;
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    if (vp.getCurrentItem() == vp.getAdapter().getCount() - 1 && !misScrolled) {
                        finishIntro();
                    }
                    misScrolled = true;
                    break;
            }
        }
    }
}

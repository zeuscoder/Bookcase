package com.zeus.ui_case.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zeus.ui_case.R;
import com.zeus.ui_case.widget.CoolMenuFrameLayout;
import com.zeus.ui_case.widget.Fragment1;
import com.zeus.ui_case.widget.Fragment2;
import com.zeus.ui_case.widget.Fragment3;
import com.zeus.ui_case.widget.Fragment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zeus_coder on 2016/1/27.
 */
public class BookCaseMenuActivity extends AppCompatActivity {

    private Button menu;
    private boolean isOpen;

    CoolMenuFrameLayout coolMenuFrameLayout;

    List<Fragment> fragments = new ArrayList<>();

    List<String> titleList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.case_activity_book_case_menu);

        coolMenuFrameLayout = (CoolMenuFrameLayout) findViewById(R.id.rl_main);
        String[] titles = {"CONTACT", "ABOUT", "TEAM", "PROJECTS"};
        titleList = Arrays.asList(titles);
        coolMenuFrameLayout.setTitles(titleList);
//        coolMenuFrameLayout.setMenuIcon(R.drawable.menu2);

        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        coolMenuFrameLayout.setAdapter(adapter);
    }
}

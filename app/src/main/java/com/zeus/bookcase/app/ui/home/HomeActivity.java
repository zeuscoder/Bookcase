package com.zeus.bookcase.app.ui.home;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchResult;
import com.yalantis.guillotine.animation.GuillotineAnimation;
import com.zeus.bookcase.R;
import com.zeus.market.MarketFragment;
import com.zeus.ui_case.CaseFragment;
import com.zeus.ui_user.MySelfFragment;

import java.util.ArrayList;

/**
 * Created by zeus_coder on 2015/11/5.
 */
public class HomeActivity extends AppCompatActivity {

    private static final long RIPPLE_DURATION = 250;
    private FragmentTransaction transaction;
    private RadioGroup tabGrouop;
    private HomeFragment homeFragment;
    private MarketFragment marketFragment;
    private CaseFragment caseFragment;
    private MySelfFragment mySelfFragment;
    private Toolbar toolbar;
    private FrameLayout root;
    private View contentHamburger;
    //
    private SearchBox search;
    private ImageView content_search;

    public View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_home);
        mainView = new View(this);

        initViews();

        //初始化Fragment
        setDefaultFragment();
        //初始化TabGroup
        tabGrouop = (RadioGroup) findViewById(R.id.fragment_group);
        tabGrouop.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        root = (FrameLayout) findViewById(R.id.root);
        contentHamburger = (View)findViewById(R.id.content_hamburger);
        //初始化搜索图标
        search = (SearchBox) findViewById(R.id.searchbox);
        content_search = (ImageView) findViewById(R.id.content_search);
        search.enableVoiceRecognition(this);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.app__activity_menu, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        content_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch();
            }
        });
    }

    public void openSearch() {
        search.revealFromMenuItem(R.id.content_search, this);
        search.setSearchListener(new SearchBox.SearchListener() {

            @Override
            public void onSearchOpened() {
                // Use this to tint the screen

            }

            @Override
            public void onSearchClosed() {
                // Use this to un-tint the screen
                closeSearch();
            }

            @Override
            public void onSearchTermChanged(String term) {
                // React to the search term changing
                // Called after it has updated results
            }

            @Override
            public void onSearch(String searchTerm) {
                Toast.makeText(HomeActivity.this, searchTerm + " Searched",
                        Toast.LENGTH_LONG).show();
                //toolbar.setTitle(searchTerm);

            }

            @Override
            public void onResultClick(SearchResult result) {
                //React to result being clicked
            }

            @Override
            public void onSearchCleared() {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            ArrayList<String> matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            search.populateEditText(matches.get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setDefaultFragment() {
        transaction = getFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.main_fragment, homeFragment);
        transaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
    }

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.tab_home:
                    if(null == homeFragment) {
                        homeFragment = new HomeFragment();
                    }
                    replaceFragment(homeFragment);
                    break;
                case R.id.tab_market:
                    if(null == marketFragment) {
                        marketFragment = new MarketFragment();
                    }
                    replaceFragment(marketFragment);
                    break;
                case R.id.tab_case:
                    if(null == caseFragment) {
                        caseFragment = new CaseFragment();
                    }
                    replaceFragment(caseFragment);
                    break;
                case R.id.tab_user:
                    if(null == mySelfFragment) {
                        mySelfFragment = new MySelfFragment();
                    }
                    replaceFragment(mySelfFragment);
                    break;
        }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK
//                && event.getAction() == KeyEvent.ACTION_DOWN) {
//            if ((System.currentTimeMillis() - exi))
//        }
        return super.onKeyDown(keyCode, event);
    }

    protected void closeSearch() {
        search.hideCircularly(this);
    }
}

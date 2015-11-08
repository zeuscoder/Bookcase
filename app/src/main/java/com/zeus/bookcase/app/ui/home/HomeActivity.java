package com.zeus.bookcase.app.ui.home;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.zeus.bookcase.R;
import com.zeus.market.MarketFragment;
import com.zeus.ui_case.CaseFragment;
import com.zeus.ui_user.MySelfFragment;

/**
 * Created by zeus_coder on 2015/11/5.
 */
public class HomeActivity extends Activity {

    private FragmentTransaction transaction;
    private RadioGroup tabGrouop;
    private HomeFragment homeFragment;
    private MarketFragment marketFragment;
    private CaseFragment caseFragment;
    private MySelfFragment mySelfFragment;

    public View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_home);
        mainView = new View(this);

        //初始化Fragment
        setDefaultFragment();
        //初始化TabGroup
        tabGrouop = (RadioGroup) findViewById(R.id.fragment_group);
        tabGrouop.setOnCheckedChangeListener(checkedChangeListener);
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
}

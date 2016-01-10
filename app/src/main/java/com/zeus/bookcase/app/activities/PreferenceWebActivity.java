package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zeus.bookcase.R;

/**
 * Created by zeus_coder on 2015/12/21.
 */
public class PreferenceWebActivity extends BaseActivity {

    private WebView web;
    private WebSettings wSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_preferentail_web);
        initTopButton(R.string.activity_book_recommend, R.mipmap.app_arrow_back, 0);
        web = (WebView) findViewById(R.id.web_preference);
        wSet = web.getSettings();
        wSet.setJavaScriptEnabled(true);

        //打开本包内asset目录下的index.html文件
        //web.loadUrl("file:///android_asset/web/prefentence.html");

        //打开本地sd卡内的index.html文件
        //web.loadUrl("content://com.android.htmlfileprovider/sdcard/prefentence.html");

        //打开指定URL的html文件
        web.loadUrl("http://ironsummitmedia.github.io/startbootstrap-agency/");
    }
}

package com.zeus.bookcase.app.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.ui.home.HomeActivity;
import com.zeus.bookcase.app.utils.Define;
import com.zeus.bookcase.app.utils.TerminalHelper;
import com.zeus.common.app.CommonDialogs;
import com.zeus.skeleton.app.AppNavigator;
import com.zeus.skeleton.app.BaseActivity;

import java.io.OutputStream;

/**
 * 欢迎启动页
 *
 * Created by zeus_coder on 2015/10/8.
 */
public class WelcomeActivity extends BaseActivity {

    //工具类
    private TerminalHelper terminalHelper;
    private Define define;

    /*定义消息常量*/
    private static final int LOAD_SPLASH_IMAGE = 0;
    private static final int DO_INIT_TASK = 1;
    private static final int TO_LOGIN_ACTIVITY = 2;
    private static final int TO_MAIN_ACTIVITY = 3;
    private String splashUri = "drawable://" + R.drawable.app__bg_splash;

    private static final String EXTRA_SUB_INTENT = "sub_intent";

    protected Dialog openingDialog;

    private ImageView imageView;

    public static Intent actionFromNotification(
            Context context, AppNavigator.SubIntent subIntent) {
        return new Intent(context, WelcomeActivity.class)
                .putExtra(EXTRA_SUB_INTENT,subIntent != null ? subIntent.toBundle():null);
    }

    /**
     * 数据库已完成修复或升级
     */
    private boolean databaseOK;

    /**
     * 动画完成
     */
    private boolean animFinished;

    /**
     * 登录检测
     */
    private boolean loginFinished;

    /**
    * 介绍页检测
    */
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private OutputStream os;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0
                && !getIntent().hasExtra(EXTRA_SUB_INTENT)) {
            finish();
            return;
        }

        setContentView(R.layout.app__activity_welcome);

        imageView = (ImageView) findViewById(R.id.lv_welcome);
        imageView.setBackgroundResource(R.mipmap.app__bg_splash);

        //显示渐变动画
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        if(getIntent().hasExtra(EXTRA_SUB_INTENT)) {
            animation.setDuration(1000);
        } else {
            animation.setDuration(3000);
        }

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animFinished = true;
                if(Build.VERSION.SDK_INT < 14) {
                    openingDialog = CommonDialogs.simpleDialogBuilder(WelcomeActivity.this)
                            .setTitle("提示")
                            .setMessage("您的手机系统版本过低，请在Android4.0或以上版本使用")
                            .setPositiveButton("退出程序", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    WelcomeActivity.this.finish();
                                }
                            })
                            .show();
                    openingDialog.setCanceledOnTouchOutside(false);
                    openingDialog.setCancelable(false);
                } else {
                    //checkGPS();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.setAnimation(animation);
        //检测登录代码
        //检测介绍页代码
        preferences = getSharedPreferences("phone", Context.MODE_PRIVATE);
        //判断是否首次启动
        if (preferences.getBoolean("fisrtstart", true)) {
            editor = preferences.edit();
            //将登录标志位设置为false，下次登录时不在显示首次登录界面
            editor.putBoolean("fisrtstart", false);
            editor.commit();
            startActivity(new Intent(WelcomeActivity.this, IntroActivity.class));
        } else {
            startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
        }
        this.finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /**
     * 检测GPS是否打开
     */
    private void checkGPS() {
        goToMainActivity();
    }

    public void goToMainActivity() {
        this.finish();
        Intent intent = new Intent(WelcomeActivity.this,IntroActivity.class);
        startActivity(intent);
/*        startActivity(IntroActivity.actionView(this, null));*/
    }
}

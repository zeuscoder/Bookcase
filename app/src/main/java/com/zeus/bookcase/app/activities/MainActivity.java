package com.zeus.bookcase.app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.event.FirstActivity;
import com.zeus.bookcase.app.event.FirstEvent;
import com.zeus.bookcase.app.ui.home.HomeActivity;
import com.zeus.skeleton.app.BaseActivity;
import com.zeus.ui_user.activity.BookListActivity;
import com.zeus.ui_user.activity.MySelfActivity;

import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {

    private static final String EXTRA_QUIT = "quit";

    private static final String EXTRA_SUB_INTENT = "sub_intent";

    private Button btn;
    private Button btn_slide;
    private Button btn_pull;
    private Button btn_book;
    private Button btn_user;
    private Button btn_home;
    private TextView tv;

    public static Intent actionView(Context context) {
        return new Intent(context, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public static Intent actionView(Context context, Intent subIntent) {
        Intent intent = actionView(context);
        if (subIntent != null) {
            intent.putExtra(EXTRA_SUB_INTENT, subIntent);
        }
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* skeleton();*/

        EventBus.getDefault().register(this);

        btn = (Button) findViewById(R.id.main);
        btn_slide = (Button) findViewById(R.id.btn_slide);
        btn_pull = (Button) findViewById(R.id.btn_pull);
        btn_book = (Button) findViewById(R.id.btn_book);
        btn_user = (Button) findViewById(R.id.btn_user);
        btn_home = (Button) findViewById(R.id.btn_home);
        tv = (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        btn_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SlideViewActivity.class);
                startActivity(intent);
            }
        });

        btn_pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PullRefreshActivity.class);
                startActivity(intent);
            }
        });

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                startActivity(intent);
            }
        });

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MySelfActivity.class);
                startActivity(intent);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

/*    private void skeleton() {
        AppComponent component = DaggerAppComponent.builder().build();
        Kettle kettle = component.providesKettle();
        kettle.on();
        kettle.brew();
        kettle.off();
    }*/

    public void onEventMainThread(FirstEvent event) {
        String msg = event.getMsg();
        Log.d("Test",msg);
        tv.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

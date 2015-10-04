package com.zeus.bookcase.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.bean.Kettle;
import com.zeus.bookcase.app.event.FirstActivity;
import com.zeus.bookcase.app.event.FirstEvent;
import com.zeus.bookcase.app.util.AppComponent;
import com.zeus.bookcase.app.util.DaggerAppComponent;

import de.greenrobot.event.EventBus;

public class MainActivity extends ActionBarActivity {

    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skeleton();

        EventBus.getDefault().register(this);

        btn = (Button) findViewById(R.id.main);
        tv = (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    private void skeleton() {
        AppComponent component = DaggerAppComponent.builder().build();
        Kettle kettle = component.providesKettle();
        kettle.on();
        kettle.brew();
        kettle.off();
    }

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

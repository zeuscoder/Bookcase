package com.zeus.bookcase.app.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.activities.RetrofitActivity;

import de.greenrobot.event.EventBus;

/**
 * Created by zeus_coder on 2015/10/1.
 */
public class FirstActivity extends Activity {

    private Button btn;
    private Button retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        btn = (Button) findViewById(R.id.first);
        retrofit = (Button) findViewById(R.id.test_retrofit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("First is onClick"));
            }
        });

        retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, RetrofitActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

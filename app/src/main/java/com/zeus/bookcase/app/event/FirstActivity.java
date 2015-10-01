package com.zeus.bookcase.app.event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeus.bookcase.R;

import de.greenrobot.event.EventBus;

/**
 * Created by zeus_coder on 2015/10/1.
 */
public class FirstActivity extends Activity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        btn = (Button) findViewById(R.id.first);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("First is onClick"));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

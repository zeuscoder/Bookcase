package com.zeus.ui_user.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.zeus.ui_user.R;

/**
 * Created by zeus_coder on 2015/12/25.
 */
public class BookListLabelActivity extends Activity {

    private FrameLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_book_label_view);

        layout = (FrameLayout) findViewById(R.id.express_show);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookListLabelActivity.this, ExpressTimeLineActivity.class));
            }
        });
    }
}

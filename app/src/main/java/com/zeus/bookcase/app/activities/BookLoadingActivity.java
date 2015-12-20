package com.zeus.bookcase.app.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeus.bookcase.R;
import com.zeus.common.load.BookLoading;


/**
 * Created by zeus_coder on 2015/11/21.
 */
public class BookLoadingActivity extends Activity{

    private BookLoading bookLoading;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_book_detail);
/*        setContentView(R.layout.activity__book_loading);
        bookLoading= (BookLoading) findViewById(R.id.bookloading);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookLoading.isStart()) {
                    button.setText("start");
                    bookLoading.stop();
                }else {
                    button.setText("stop");
                    bookLoading.start();
                }
            }
        });*/
    }
}

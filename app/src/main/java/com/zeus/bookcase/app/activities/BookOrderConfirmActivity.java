package com.zeus.bookcase.app.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.zeus.bookcase.R;

import babushkatext.BabushkaText;

/**
 * Created by zeus_coder on 2016/1/10.
 */
public class BookOrderConfirmActivity extends BaseActivity {

    private BabushkaText oldPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_order_confirm);
        initTopButton(R.string.activity_order_confirm, R.mipmap.app_arrow_back, 0);

        oldPrice = (BabushkaText) findViewById(R.id.order_book_old_price);
        oldPrice.addPiece(new BabushkaText.Piece.Builder("$256")
                .textColor(Color.parseColor("#5F5F5F"))
                .superscript()
                .strike()
                .textSizeRelative(0.9f)
                .style(Typeface.BOLD)
                .build());
    }
}

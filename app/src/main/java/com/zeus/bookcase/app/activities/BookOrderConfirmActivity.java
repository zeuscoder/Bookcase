package com.zeus.bookcase.app.activities;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;

import com.zeus.bookcase.R;



/**
 * Created by zeus_coder on 2016/1/10.
 */
public class BookOrderConfirmActivity extends BaseActivity {

    private TextView oldPriceTV;

    private String oldPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_order_confirm);
        initTopButton(R.string.activity_order_confirm, R.mipmap.app_arrow_back, 0);

        oldPrice = "￥15";

        oldPriceTV = (TextView) findViewById(R.id.order_book_old_price);
        SpannableStringBuilder ssb = new SpannableStringBuilder(oldPrice);
        ssb.setSpan(new StrikethroughSpan(), 0, oldPrice.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        oldPriceTV.setText(ssb);

    }
}

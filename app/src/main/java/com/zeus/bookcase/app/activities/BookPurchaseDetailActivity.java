package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zeus.bookcase.R;

/**
 * Created by zeus_coder on 2015/12/29.
 */
public class BookPurchaseDetailActivity extends BaseActivity {

    private TextView purchase;
    private TextView addCart;

    private TextView favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_purchase_detail);
        initTopButton(R.string.activity_book_detail, R.mipmap.app_arrow_back, 0);

        purchase = (TextView) findViewById(R.id.book_purchase);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookPurchaseDetailActivity.this, BookOrderConfirmActivity.class));
            }
        });

        addCart = (TextView) findViewById(R.id.book_add_shopping_cart);
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookPurchaseDetailActivity.this, "已经加入购物车了噢~亲", Toast.LENGTH_SHORT).show();
            }
        });

        favorite = (TextView) findViewById(R.id.book_add_favorite);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookPurchaseDetailActivity.this, "已经加入收藏夹了噢~亲", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

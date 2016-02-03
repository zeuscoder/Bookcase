package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.view.BannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeus_coder on 2015/12/29.
 */
public class BookPurchaseDetailActivity extends BaseActivity {

    //广告栏
    private BannerLayout banner;

    private TextView purchase;
    private TextView addCart;

    private TextView favorite;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__activity_purchase_detail);
        initTopButton(R.string.activity_book_detail, R.mipmap.app_arrow_back, 0);

        banner = (BannerLayout) findViewById(R.id.banner);
        List<String> urls = new ArrayList<>();
        urls.add("http://img3.imgtn.bdimg.com/it/u=2674591031,2960331950&fm=23&gp=0.jpg");
        urls.add("http://img5.imgtn.bdimg.com/it/u=3639664762,1380171059&fm=23&gp=0.jpg");
        urls.add("http://img0.imgtn.bdimg.com/it/u=1095909580,3513610062&fm=23&gp=0.jpg");
        urls.add("http://img4.imgtn.bdimg.com/it/u=1030604573,1579640549&fm=23&gp=0.jpg");
        urls.add("http://img5.imgtn.bdimg.com/it/u=2583054979,2860372508&fm=23&gp=0.jpg");
        banner.setViewUrls(urls);
        //添加监听事件
        banner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(BookPurchaseDetailActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

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
                //Toast.makeText(BookPurchaseDetailActivity.this, "已经加入购物车了噢~亲", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookPurchaseDetailActivity.this, TestActivity.class));
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

package com.zeus.ui_user.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.zeus.ui_user.R;
import com.zeus.ui_user.adapter.ShoppingCartAdapter;

/**
 * Created by zeus_coder on 2016/1/10.
 */
public class UserShoppingCartActivity extends BaseActivity {

    private ListView goodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_shopping_cart);
        initTopButton(R.string.activity_shopping_cart,R.mipmap.user_arrow_back, 0);
        //setContentView(R.layout.user_item_shopping_cart);

        goodList = (ListView) findViewById(R.id.list_shopping_cart);
        goodList.setAdapter(new ShoppingCartAdapter(this));
    }
}

package com.zeus.ui_user.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeus.ui_user.R;

/**
 * Created by zeus_coder on 2016/1/10.
 */
public class ShoppingCartAdapter extends BaseAdapter{

    private Context context;

    public ShoppingCartAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.user_item_shopping_cart, null);
            viewHolder = new ViewHolder();
            viewHolder.goodShopIcon = (ImageView) view.findViewById(R.id.good_shop_icon);
            viewHolder.goodShopName = (TextView) view.findViewById(R.id.good_shop_name);
            viewHolder.goodBookImage = (ImageView) view.findViewById(R.id.good_book_image);
            viewHolder.goodBookName = (TextView) view.findViewById(R.id.good_book_name);
            viewHolder.goodBookDerc = (TextView) view.findViewById(R.id.good_book_desc);
            viewHolder.goodNewPrice = (TextView) view.findViewById(R.id.good_book_new_price);
            viewHolder.goodOldPrice = (TextView) view.findViewById(R.id.good_book_old_price);
            viewHolder.goodBookCount = (TextView) view.findViewById(R.id.good_book_count);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
/*        viewHolder.banner.setBackgroundResource(R.mipmap.app_label_recommend_book_banner_bg);
        viewHolder.title.setText("IT宅男的周末");
        viewHolder.number.setText("100");
        viewHolder.item1.setBackgroundResource(R.mipmap.app_label_recommend_book_item1);
        viewHolder.item2.setBackgroundResource(R.mipmap.app_label_recommend_book_item2);
        viewHolder.item3.setBackgroundResource(R.mipmap.app_label_recommend_book_item3);
        viewHolder.item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BookPurchaseDetailActivity.class));
            }
        });*/
        return view;
    }

    class ViewHolder {
        private ImageView goodShopIcon;
        private TextView goodShopName;
        private ImageView goodBookImage;
        private TextView goodBookName;
        private TextView goodBookDerc;
        private TextView goodNewPrice;
        private TextView goodOldPrice;
        private TextView goodBookCount;
    }
}

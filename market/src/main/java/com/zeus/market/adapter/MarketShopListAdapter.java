package com.zeus.market.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeus.market.R;

/**
 * Created by zeus_coder on 2015/12/27.
 */
public class MarketShopListAdapter extends BaseAdapter{

    private Context context;

    public MarketShopListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 7;
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
            view = LayoutInflater.from(context).inflate(R.layout.market_main_item_hottest_shop, null);
            viewHolder = new ViewHolder();
            viewHolder.photo = (ImageView) view.findViewById(R.id.market_shop_photo);
            viewHolder.name = (TextView) view.findViewById(R.id.market_shop_name);
            viewHolder.time = (TextView) view.findViewById(R.id.market_shop_time);
            viewHolder.description = (TextView) view.findViewById(R.id.market_shop_description);
            viewHolder.item1 = (ImageView) view.findViewById(R.id.market_shop_book_item1);
            viewHolder.item2 = (ImageView) view.findViewById(R.id.market_shop_book_item2);
            viewHolder.item3 = (ImageView) view.findViewById(R.id.market_shop_book_item3);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.photo.setBackgroundResource(R.mipmap.ads_1);
        viewHolder.name.setText("Zeus旗舰店");
        viewHolder.time.setText("今天 0点45分");
        viewHolder.description.setText("粉丝特权 最新最热的书单");
        viewHolder.item1.setBackgroundResource(R.mipmap.market_shop_book_item1);
        viewHolder.item2.setBackgroundResource(R.mipmap.market_shop_book_item2);
        viewHolder.item3.setBackgroundResource(R.mipmap.market_shop_book_item3);
        return view;
    }

    class ViewHolder {
        private ImageView photo;
        private TextView name;
        private TextView time;
        private TextView description;
        private ImageView item1;
        private ImageView item2;
        private ImageView item3;
    }
}

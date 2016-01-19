package com.zeus.ui_user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeus.ui_user.R;

/**
 * Created by zeus_coder on 2016/1/13.
 */
public class WelfareAdapter extends BaseAdapter{

    private Context context;

    public WelfareAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
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
            view = LayoutInflater.from(context).inflate(R.layout.user_item_welfare, null);
            viewHolder = new ViewHolder();
            viewHolder.welfareIcon = (ImageView) view.findViewById(R.id.welfare_icon);
            viewHolder.welfareTitle = (TextView) view.findViewById(R.id.welfare_title);
            viewHolder.welfareContent = (TextView) view.findViewById(R.id.welfare_content);
            viewHolder.welfareTask = (TextView) view.findViewById(R.id.welfare_task);
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
        private ImageView welfareIcon;
        private TextView welfareTitle;
        private TextView welfareContent;
        private TextView welfareTask;
    }
}

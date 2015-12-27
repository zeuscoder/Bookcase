package com.zeus.bookcase.app.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zeus.bookcase.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by zeus_coder on 2015/12/27.
 */
public class LabelRecommendGeekListAdapter extends BaseAdapter {

    private List geeks;
    private Context context;

    public LabelRecommendGeekListAdapter(Context context) {
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
            view = LayoutInflater.from(context).inflate(R.layout.app_home_geek_item, null);
            viewHolder = new ViewHolder();
            viewHolder.photo = (CircleImageView) view.findViewById(R.id.home_geek_photo);
            viewHolder.name = (TextView) view.findViewById(R.id.home_geek_name);
            viewHolder.title = (TextView) view.findViewById(R.id.home_geek_title);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.photo.setBackgroundResource(R.mipmap.app_home_geek_photo);
        viewHolder.name.setText("Zeus");
        viewHolder.title.setText("帅气达人");
        return view;
    }

    class ViewHolder {
        private CircleImageView photo;
        private TextView name;
        private TextView title;
    }
}

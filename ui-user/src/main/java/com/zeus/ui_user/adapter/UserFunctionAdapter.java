package com.zeus.ui_user.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeus.ui_user.R;
import com.zeus.ui_user.model.Function;

import java.util.List;

/**
 * Created by zeus_coder on 2015/12/28.
 */
public class UserFunctionAdapter extends BaseAdapter {

    private List<Function> functions;
    private Context context;

    public UserFunctionAdapter(Context context, List functions) {
        this.context = context;
        this.functions = functions;
    }

    @Override
    public int getCount() {
        return 8;
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
            view = LayoutInflater.from(context).inflate(R.layout.user_item_function, null);
            viewHolder = new ViewHolder();
            viewHolder.photo = (ImageView) view.findViewById(R.id.user_function_icon);
            viewHolder.name = (TextView) view.findViewById(R.id.user_function_name);
            viewHolder.title = (TextView) view.findViewById(R.id.user_function_title);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Function function = functions.get(position);
        //viewHolder.photo.setBackgroundResource(geek.getPhoto());
        viewHolder.photo.setBackgroundResource(function.getIcon());
        viewHolder.name.setText(function.getName() + position);
        viewHolder.title.setText(function.getTitle());
        Log.d("user----------------", function.getIcon() + "");
        Log.d("user----------------", function.getName());
        return view;
    }

    class ViewHolder {
        private ImageView photo;
        private TextView name;
        private TextView title;
    }
}

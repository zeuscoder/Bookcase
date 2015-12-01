package com.zeus.market;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.zeus.common.NonGridViewAdapter;
import com.zeus.common.widget.NonScrollingGridView;

/**
 * Created by zeus_coder on 2015/11/7.
 */
public class MarketFragment extends Fragment {

    //存放各功能图片
    private Integer[] mFunctionPics = {R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon};
    private NonScrollingGridView specialAdView;
    private GridView gridView;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View EntryView = inflater.inflate(R.layout.market_fragment_main, container,
                false);
/*        gridView = (GridView) EntryView.findViewById(R.id.ads);
        gridView.setAdapter(new ImageAdapter(this.getActivity()));*/
        return EntryView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        specialAdView = (NonScrollingGridView) view.findViewById(R.id.market_ads);
        imageView = (ImageView) view.findViewById(R.id.news);
        /*
        * 填充数据
        * */
        int[] images = new int[] {R.mipmap.ads_1,R.mipmap.ads_2,R.mipmap.ads_3,R.mipmap.ads_4};
        specialAdView.setAdapter(new NonGridViewAdapter(getActivity(), images));
        specialAdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"he",Toast.LENGTH_SHORT).show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"he",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), BookDiscountActivity.class));
            }
        });
    }

 /*   public class ImageAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater inflater;

        public ImageAdapter(Context c){
            mContext = c;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mFunctionPics.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.ids_grid_view_item, null);
            }
            ImageView imageView = Tools.ViewHolder.get(convertView, R.id.icon);
            imageView.setImageResource(R.drawable.icon);
            return convertView;
        }
    }*/
}

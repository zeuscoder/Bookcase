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
import android.widget.ListView;
import android.widget.Toast;

import com.zeus.common.NonGridViewAdapter;
import com.zeus.common.widget.NonScrollingGridView;
import com.zeus.market.adapter.MarketShopListAdapter;

/**
 * Created by zeus_coder on 2015/11/7.
 */
public class MarketFragment extends Fragment {

    private ListView shopList;

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
        View EntryView = inflater.inflate(R.layout.market_fragment_index, container,
                false);
        return EntryView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shopList = (ListView) view.findViewById(R.id.market_list_shop);
        shopList.setAdapter(new MarketShopListAdapter(getActivity()));
    }


}

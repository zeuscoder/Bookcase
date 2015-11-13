package com.zeus.ui_user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zeus_coder on 2015/10/31.
 */
public class MySelfFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user__fragment_myself, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        //fillView();
    }

    private void initUI(View view) {

    }

    private void fillView() {
        initTopBar(R.string.user_myself, 0);
    }

    private void initTopBar(int titleId, int rightStrId) {
        if(getView() == null) {
            return;
        }
        ((TextView)getView().findViewById(R.id.topbar_title)).setText(this.getString(titleId));
        getView().findViewById(R.id.leftBtn).setVisibility(View.GONE);
        TextView btnRight = (TextView)getView().findViewById(R.id.rightBtn);
        if(rightStrId == 0) {
            btnRight.setVisibility(View.GONE);
        } else {
            btnRight.setVisibility(View.VISIBLE);
            btnRight.setText(getResources().getString(rightStrId));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {

    }
}

package com.zeus.ui_user.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zeus_coder on 2015/12/2.
 */
public class FirstFragment  extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView text = new TextView(container.getContext());
        text.setText("Fragment content");
        text.setGravity(Gravity.CENTER);

        return text;
    }
}

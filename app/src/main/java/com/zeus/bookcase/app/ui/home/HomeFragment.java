package com.zeus.bookcase.app.ui.home;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.activities.BookFoldableActivity;


/**
 * Created by zeus_coder on 2015/11/5.
 */
public class HomeFragment extends Fragment {

    private ImageView centerimagview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        centerimagview = (ImageView) view.findViewById(R.id.centerimagview);
        centerimagview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookFoldableActivity.class));
            }
        });
    }
}

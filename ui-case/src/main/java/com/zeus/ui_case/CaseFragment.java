package com.zeus.ui_case;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zeus.ui_case.activity.BookLibraryActivity;
import com.zeus.ui_case.activity.DetailActivity;
import com.zeus.ui_case.activity.MusicCardActivity;

/**
 * Created by zeus_coder on 2015/11/7.
 */
public class CaseFragment extends Fragment {

    private LinearLayout bookStore;
    private LinearLayout musicStore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.case_fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bookStore = (LinearLayout) view.findViewById(R.id.book_store);
        musicStore = (LinearLayout) view.findViewById(R.id.music_store);
        bookStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getActivity(), DetailActivity.class));
                startActivity(new Intent(getActivity(), BookLibraryActivity.class));
            }
        });
        musicStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MusicCardActivity.class));
            }
        });
    }
}

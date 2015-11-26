package com.zeus.bookcase.app.activities;

import android.app.Activity;
import android.os.Bundle;

import com.zeus.bookcase.R;
import com.zeus.bookcase.app.adpter.ImageCoverViewAdapter;
import com.zeus.common.image.CoverFlowView;

/**
 * Created by zeus_coder on 2015/11/25.
 */
public class ImageCoverViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app__image_cover_view);
        CoverFlowView<ImageCoverViewAdapter> mCoverFlowView =
                (CoverFlowView<ImageCoverViewAdapter>) findViewById(R.id.coverflow);

    }
}

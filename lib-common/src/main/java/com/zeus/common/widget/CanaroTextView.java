package com.zeus.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zeus_coder on 2015/11/12.
 */
public class CanaroTextView extends TextView {

    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    private static Typeface canaroExtraBold;

    public CanaroTextView(Context context) {
        this(context, null);
    }

    public CanaroTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanaroTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        canaroExtraBold = Typeface.createFromAsset(context.getAssets(), CANARO_EXTRA_BOLD_PATH);
        setTypeface(canaroExtraBold);
    }
}

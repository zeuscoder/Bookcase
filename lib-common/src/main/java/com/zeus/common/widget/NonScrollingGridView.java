package com.zeus.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import com.zeus.common.ViewUtils;

/**
 * Created by zeus_coder on 2015/11/14.
 */
public class NonScrollingGridView extends GridView {
    public NonScrollingGridView(Context context) {
        super(context);
    }

    public NonScrollingGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NonScrollingGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 设置不滚动
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

//    @Override
//    protected void onDetachedFromWindow() {
//        if(!ViewUtils.isAttachedToWindow(this)) {
//            return;
//        }
//        super.onDetachedFromWindow();
//    }
}

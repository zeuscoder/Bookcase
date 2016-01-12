package com.zeus.ui_user.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zeus.ui_user.R;
import com.zeus.ui_user.view.ExpressTimelineView;

/**
 * Created by zeus_coder on 2015/12/26.
 */
public class ExpressTimeLineViewHolder extends RecyclerView.ViewHolder {

    public TextView thing;
    public TextView time;
    public ExpressTimelineView mTimelineView;

    public ExpressTimeLineViewHolder(View itemView, int viewType) {
        super(itemView);
        thing = (TextView) itemView.findViewById(R.id.tx_thing);
        time = (TextView) itemView.findViewById(R.id.tx_time);
        mTimelineView = (ExpressTimelineView) itemView.findViewById(R.id.time_marker);
        mTimelineView.initLine(viewType);
    }
}

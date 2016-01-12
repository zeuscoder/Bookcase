package com.zeus.ui_user.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zeus.ui_user.R;
import com.zeus.ui_user.holder.ExpressTimeLineViewHolder;
import com.zeus.ui_user.model.ExpressTimeLineModel;
import com.zeus.ui_user.view.ExpressTimelineView;

import java.util.List;

/**
 * Created by zeus_coder on 2015/12/26.
 */
public class ExpressTimeLineAdapter extends RecyclerView.Adapter<ExpressTimeLineViewHolder>{

    private List<ExpressTimeLineModel> mFeedList;

    public ExpressTimeLineAdapter(List<ExpressTimeLineModel> feedList) {
        mFeedList = feedList;
    }

    @Override
    public int getItemViewType(int position) {
        return ExpressTimelineView.getTimeLineViewType(position, getItemCount());
    }

    @Override
    public ExpressTimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.book_item_express_timeline, null);
        return new ExpressTimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ExpressTimeLineViewHolder holder, int position) {
        ExpressTimeLineModel timeLineModel = mFeedList.get(position);
        holder.thing.setText(timeLineModel.getThing());
        holder.time.setText(timeLineModel.getTime());
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }
}

package com.internship.yalantis.task2.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.activities.DetailTaskActivity;
import com.internship.yalantis.task2.activities.Task;
import com.internship.yalantis.task2.models.TaskDataModel;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<TaskDataModel> mTaskDataModel;
    public TaskAdapter(ArrayList<TaskDataModel> taskDataModel){
        this.mTaskDataModel = taskDataModel;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_recycler_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder mItemHolder = (ItemViewHolder) holder;
        TaskDataModel task = mTaskDataModel.get(position);
        mItemHolder.mItemTitle.setText(task.getmTitle());
        mItemHolder.mItemContent.setText(task.getmContent());
        mItemHolder.mItemDate.setText(task.getmDate());
        mItemHolder.mItemTime.setText(task.getmTime());
        mItemHolder.mLikeCount.setText(task.getmLikeCount());
        mItemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), DetailTaskActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTaskDataModel.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_title)
        TextView mItemTitle;
        @Bind(R.id.like_count)
        TextView mLikeCount;
        @Bind(R.id.item_content)
        TextView mItemContent;
        @Bind(R.id.item_date)
        TextView mItemDate;
        @Bind(R.id.item_time)
        TextView mItemTime;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}

package com.internship.yalantis.task2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.models.TaskDataModel;


import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ItemViewHolder> {
    private ArrayList<TaskDataModel> mTaskDataModel;
    private static OnItemClickListener sListener;

    public TaskAdapter(ArrayList<TaskDataModel> taskDataModel) {
        this.mTaskDataModel = taskDataModel;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        sListener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_recycler_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        TaskDataModel task = mTaskDataModel.get(position);
        holder.itemTitle.setText(task.getTitle());
        holder.itemContent.setText(task.getContent());
        holder.itemDate.setText(task.getDate());
        holder.itemTime.setText(task.getTime());
        holder.likeCount.setText(task.getLikeCount());
    }

    @Override
    public int getItemCount() {
        return mTaskDataModel.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_title)
        TextView itemTitle;
        @Bind(R.id.like_count)
        TextView likeCount;
        @Bind(R.id.item_content)
        TextView itemContent;
        @Bind(R.id.item_date)
        TextView itemDate;
        @Bind(R.id.item_time)
        TextView itemTime;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sListener != null)
                        sListener.onItemClick(itemView, getLayoutPosition());
                }
            });
        }
    }
}

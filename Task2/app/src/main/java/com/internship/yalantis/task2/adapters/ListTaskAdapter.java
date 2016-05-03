package com.internship.yalantis.task2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.models.TaskDataModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListTaskAdapter extends BaseAdapter {
    private List<TaskDataModel> mTaskDataModel;

    public ListTaskAdapter() {
    }
    public void setTaskList(List<TaskDataModel> taskDataModel) {
        this.mTaskDataModel = taskDataModel;
    }
    @Override
    public int getCount() {
        return mTaskDataModel.size();
    }

    @Override
    public Object getItem(int position) {
        return mTaskDataModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskDataModel task = mTaskDataModel.get(position);
        ItemHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_recycler_item, parent, false);
        }
        holder = new ItemHolder(convertView);
        convertView.setTag(holder);
        holder.itemTitle.setText(task.getTitle());
        holder.itemContent.setText(task.getContent());
        holder.itemDate.setText(task.getDate());
        holder.itemTime.setText(task.getTime());
        holder.likeCount.setText(task.getLikeCount());
        return convertView;
    }

    static class ItemHolder {
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

        public ItemHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

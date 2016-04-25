package com.internship.yalantis.task2.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.activities.DetailTaskActivity;
import com.internship.yalantis.task2.models.TaskDataModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListTaskAdapter extends ArrayAdapter<TaskDataModel> {


    public ListTaskAdapter(Context context, ArrayList<TaskDataModel> taskDataModels) {
        super(context, 0, taskDataModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskDataModel task = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_recycler_item, parent, false);
        }
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);
        holder.itemTitle.setText(task.getTitle());
        holder.itemContent.setText(task.getContent());
        holder.itemDate.setText(task.getDate());
        holder.itemTime.setText(task.getTime());
        holder.likeCount.setText(task.getLikeCount());
        return convertView;
    }

    static class ViewHolder {
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

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

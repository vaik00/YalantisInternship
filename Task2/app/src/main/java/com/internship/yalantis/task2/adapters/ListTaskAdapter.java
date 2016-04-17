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
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_recycler_item, parent, false);
        }
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);
        holder.mItemTitle.setText(task.getmTitle());
        holder.mItemContent.setText(task.getmContent());
        holder.mItemDate.setText(task.getmDate());
        holder.mItemTime.setText(task.getmTime());
        holder.mLikeCount.setText(task.getmLikeCount());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), DetailTaskActivity.class));
            }
        });
        return convertView;
    }
    static class ViewHolder {
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

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

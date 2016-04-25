package com.internship.yalantis.task2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.activities.DetailTaskActivity;
import com.internship.yalantis.task2.adapters.TaskAdapter;
import com.internship.yalantis.task2.models.TaskDataModel;
import com.internship.yalantis.task2.utils.JsonManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TaskFragment extends Fragment {
    @Bind(R.id.task_recycler)
    RecyclerView mTaskRecycler;

    public static TaskFragment newInstance() {
        return new TaskFragment();
    }

    public TaskFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tasks, container, false);
        ButterKnife.bind(this, rootView);
        TaskAdapter taskAdapter = new TaskAdapter(getData());
        setupTaskRecycler(taskAdapter);
        taskAdapter.setOnItemClickListener(new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                getContext().startActivity(new Intent(getContext(), DetailTaskActivity.class));
            }
        });
        return rootView;
    }

    private void setupTaskRecycler(TaskAdapter adapter) {
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext());
        mTaskRecycler.setLayoutManager(mLinearLayoutManager);
        mTaskRecycler.setAdapter(adapter);
    }

    private ArrayList<TaskDataModel> getData() {
        InputStream fileStream = getResources().openRawResource(R.raw.data);
        String data = JsonManager.getInstance().readTextFile(fileStream);
        Gson gson = new Gson();
        return gson.fromJson(data, new TypeToken<List<TaskDataModel>>() {
        }.getType());
    }
}

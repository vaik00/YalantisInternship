package com.internship.yalantis.task2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.activities.DetailTaskActivity;
import com.internship.yalantis.task2.adapters.ListTaskAdapter;
import com.internship.yalantis.task2.models.TaskDataModel;
import com.internship.yalantis.task2.utils.JsonManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListTaskFragment extends Fragment {
    @Bind(R.id.list_item)
    ListView mTaskList;

    public static ListTaskFragment newInstance() {
        return new ListTaskFragment();
    }

    public ListTaskFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_tasks, container, false);
        ButterKnife.bind(this, rootView);
        ViewCompat.setNestedScrollingEnabled(mTaskList, true);
        mTaskList.setAdapter(new ListTaskAdapter(getContext(), getData()));
        mTaskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getContext().startActivity(new Intent(getContext(), DetailTaskActivity.class));
            }
        });

        return rootView;
    }

    private ArrayList<TaskDataModel> getData() {
        InputStream fileStream = getResources().openRawResource(R.raw.data);
        String data = JsonManager.getInstance().readTextFile(fileStream);
        Gson gson = new Gson();
        return gson.fromJson(data, new TypeToken<List<TaskDataModel>>() {
        }.getType());
    }
}

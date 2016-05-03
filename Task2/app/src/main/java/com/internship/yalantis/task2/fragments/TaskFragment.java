package com.internship.yalantis.task2.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.activities.DetailTaskActivity;
import com.internship.yalantis.task2.activities.TaskActivity;
import com.internship.yalantis.task2.adapters.ListTaskAdapter;
import com.internship.yalantis.task2.adapters.TaskAdapter;
import com.internship.yalantis.task2.models.TaskDataModel;
import com.internship.yalantis.task2.utils.FabOwner;
import com.internship.yalantis.task2.utils.JsonManager;

import java.io.InputStream;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TaskFragment extends Fragment {
    @Bind(R.id.task_recycler)
    RecyclerView mTaskRecycler;
    @Bind(R.id.list_item)
    ListView mTaskList;
    private FloatingActionButton mFab;
    private int mType;

    public static TaskFragment newInstance(int type) {
        TaskFragment taskFragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        taskFragment.setArguments(args);
        return taskFragment;
    }

    public TaskFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFab = null;
        if (context instanceof FabOwner) {
            mFab = ((FabOwner) context).getFloatingActionButton();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tasks, container, false);
        ButterKnife.bind(this, rootView);
        setupViewFromType();
        return rootView;
    }

    private void setupViewFromType() {
        switch (mType) {
            case TaskActivity.TYPE_LIST:
                setupTaskList();
                break;
            default:
                setupTaskRecycler();
                break;
        }
    }

    private void setupTaskRecycler() {
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext());
        TaskAdapter taskAdapter = new TaskAdapter();
        mTaskRecycler.setLayoutManager(mLinearLayoutManager);
        mTaskRecycler.setAdapter(taskAdapter);
        taskAdapter.setTaskList(getData());
        taskAdapter.notifyDataSetChanged();
        taskAdapter.setOnItemClickListener(new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                getContext().startActivity(new Intent(getContext(), DetailTaskActivity.class));
            }
        });
    }

    private void setupTaskList() {
        ViewCompat.setNestedScrollingEnabled(mTaskList, true);
        ListTaskAdapter listAdapter = new ListTaskAdapter();
        listAdapter.setTaskList(getData());
        listAdapter.notifyDataSetChanged();
        mTaskList.setAdapter(listAdapter);
        mTaskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getContext().startActivity(new Intent(getContext(), DetailTaskActivity.class));
            }
        });
        if (mFab != null) {
            mTaskList.setOnScrollListener(new AbsListView.OnScrollListener() {
                private int mLastFirstVisibleItem = 0;

                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    int fabVisibility = mFab.getVisibility();
                    if (firstVisibleItem > mLastFirstVisibleItem && fabVisibility == View.VISIBLE) {
                        mFab.hide();
                    } else if (firstVisibleItem < mLastFirstVisibleItem && fabVisibility == View.GONE) {
                        mFab.show();
                    }
                    mLastFirstVisibleItem = firstVisibleItem;
                }
            });
        }
    }

    private List<TaskDataModel> getData() {
        InputStream fileStream = getResources().openRawResource(R.raw.data);
        String data = JsonManager.getInstance().readTextFile(fileStream);
        Gson gson = new Gson();
        return gson.fromJson(data, new TypeToken<List<TaskDataModel>>() {
        }.getType());
    }
}

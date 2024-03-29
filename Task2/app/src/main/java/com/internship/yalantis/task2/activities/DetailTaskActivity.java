package com.internship.yalantis.task2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.adapters.ImageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailTaskActivity extends AppCompatActivity {

    @OnClick({R.id.created,
            R.id.registered,
            R.id.in_progress,
            R.id.title,
            R.id.resolve,
            R.id.responsible,
            R.id.resolve_value,
            R.id.responsible_value,
            R.id.created_value,
            R.id.registered_value,
            R.id.content
    })

    public void showToast(View view) {
        Toast.makeText(this,
                ((TextView) view).getText(), Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        setupImages();
    }

    private void setupImages() {
        List<String> images = Arrays.asList(getResources().getStringArray(R.array.images));
        RecyclerView imagesContainer = ButterKnife.findById(this, R.id.images_container);
        imagesContainer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ImageAdapter imageAdapter = new ImageAdapter(images);
        imagesContainer.setAdapter(imageAdapter);
        imageAdapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(getApplicationContext(),
                        "ImageView " + position,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

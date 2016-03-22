package com.yalantis.task1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//[Comment] Wrong toolbar and status bar color
public class Main extends AppCompatActivity { //[Comment] Main what? Use informative class names
    @Bind(R.id.images_container)
    RecyclerView imagesContainer; //[Comment] You don't need this object like class field
    @Bind(R.id.created)
    TextView created;
    @Bind(R.id.registered)
    TextView registered;
    @Bind(R.id.in_progress)
    TextView inProgress;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.resolve)
    TextView resolve;
    @Bind(R.id.responsible)
    TextView responsible;
    @Bind(R.id.resolve_value)
    TextView resolveValue;
    @Bind(R.id.responsible_value)
    TextView responsibleValue;
    @Bind(R.id.created_value)
    TextView createdValue;
    @Bind(R.id.registered_value)
    TextView registeredValue;
    @Bind(R.id.content)
    TextView content; //[Comment] Unused objects. Wrong names

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //[Comment] Sometimes it can be null. Please add if else check
        ButterKnife.bind(this);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        List<String> images = Arrays.asList(getResources().getStringArray(R.array.images));
        imagesContainer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        imagesContainer.setAdapter(new ImageAdapter(images, this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main.this, Main.class); //[Comment] Awful. 1. You don't need to override onBackPressed
        //                                                                    2. Anyway you can just call finish() instead of recalling activity, and checking by flag
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
}

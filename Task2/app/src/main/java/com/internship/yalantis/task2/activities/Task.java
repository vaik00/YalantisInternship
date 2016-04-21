package com.internship.yalantis.task2.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.internship.yalantis.task2.R;
import com.internship.yalantis.task2.fragments.ListTaskFragment;
import com.internship.yalantis.task2.fragments.TaskFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

// Task - wrong name for activity
// Task (32) - some fields can be local
// Task (102) - empty if-statement
// Task (128) - use default case in switch 
// Task (138) - use default case in switch 


// DetailTaskActivity (61) -  use default case in switch 


// ImageAdapter (33) - item position should not be final in adapter
// ImageAdapter (39) - don’t implement OnClickListener in adapter


// ListTaskAdapter (36) - you always create new instance of view holder, so you never use the value assigned to your holder at line#32
// ListTaskAdapter (43) - don’t implement OnClickListener in adapter
// ListTaskAdapter (46) - don’t open activities in adapter
// ListTaskAdapter (53) - wrong fields naming


// TaskAdapter (21) - you should use your view holder realization here not RecyclerView.ViewHolder
// TaskAdapter (22) - use abstraction, not realization
// TaskAdapter (28) - why not to initialize v when you declare it?
// TaskAdapter (35) - you don’t need to cast the holder (see #13)
// TaskAdapter (42) - don’t implement OnClickListener in adapter, don’t open activities in adapter
// TaskAdapter (57) - wrong fields naming


// ListTaskFragment (43) - your onCreateView() method has too much responsibilies. Separate it into some smaller methods. Your View must not access your data, this is your Presenter’s responsibility 
// ListTaskFragment (46) - use abstraction, not realization
// ListTaskFragment (55) - empty method
// ListTaskFragment (60) - empty method


// TaskFragment (43) - your onCreateView() method has too much responsibilies. Separate it into some smaller methods. Your View must not access your data, this is your Presenter’s responsibility 
// TaskFragment (46) - use abstraction, not realization
// TaskFragment (55) - empty method
// TaskFragment (61) - empty method
// Your ListTaskFragment and TaskFragment have too much in common. Create base fragment 


// TaskDataModel (7) - wrong fields naming
// TaskDataModel (24) - wrong methods naming. They should not contain ‘m’ prefics
// TaskDataModel (24) - The responsibility of getters and setters is obvious, so no need in comments on them


// HideFabOnScroll is never used


// JsonManager should be singleton 


// Wrong resourses naming (can.xml, f_a_b_2_x.png, paper.xml, task.xml .. )
// Use CTRL + ALT + L (Win)/OPTION + CMD + L (Mac) combination to reformat code
// content_main.xml - too much repeating code
// content_main.xml (13) - check your activity location
// holder_item.xml - image view can be root view

public class Task extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.task_title);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setElevation(0f);
        }


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_filter || super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_issues) {
        } else if (id == R.id.nav_map_requests) {

        } else if (id == R.id.nav_sign_in) {
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TaskFragment.newInstance();
                case 1:
                    return TaskFragment.newInstance();
                case 2:
                    return ListTaskFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.in_progress);
                case 1:
                    return getString(R.string.completed);
                case 2:
                    return getString(R.string.failed);
            }
            return null;
        }
    }
}

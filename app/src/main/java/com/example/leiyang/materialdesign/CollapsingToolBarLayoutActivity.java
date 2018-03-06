package com.example.leiyang.materialdesign;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolBarLayoutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tool_bar_layout);


        mToolbar = findViewById(R.id.toolBar);
        mToolbar.setTitle("凤凰新闻");
        recyclerView = findViewById(R.id.recyclerView);
        setSupportActionBar(mToolbar);

        collapsingToolbarLayout = findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitle("2018");

        initViewPager();

    }

    private void initViewPager() {

        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myRecycleViewAdapter);

    }
}

package com.example.leiyang.materialdesign;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

public class MyFooterBehaviorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_footer_behavior);


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
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myRecycleViewAdapter);

    }
}

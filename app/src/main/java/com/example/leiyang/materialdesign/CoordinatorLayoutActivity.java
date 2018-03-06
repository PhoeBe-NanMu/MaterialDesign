package com.example.leiyang.materialdesign;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 24436 on 2018/2/11.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_coordinatorlayout);

        mToolbar = findViewById(R.id.toolBar);
        mToolbar.setTitle("凤凰新闻");
        mViewPager = findViewById(R.id.viewPager);
        setSupportActionBar(mToolbar);

        initViewPager();

    }

    private void initViewPager() {

        mTabLayout = findViewById(R.id.tabLayout);

        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热点");
        titles.add("精选");
        titles.add("图片");
        titles.add("科技");
        titles.add("娱乐");
        titles.add("游戏");
        titles.add("体育");
        titles.add("财经");
        titles.add("搞笑");
        titles.add("更多");

        for (int i = 0 ; i< titles.size(); i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        List<android.support.v4.app.Fragment> fragmentList = new ArrayList<>();

        for (int i = 0 ; i< titles.size(); i++){
            fragmentList.add(new MyListFragment());
        }

        FragmentAdapter mFragmentAdapteradapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);

    }
}

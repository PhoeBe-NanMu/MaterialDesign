package com.example.leiyang.materialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 24436 on 2018/2/11.
 */



public class DrawerLayoutActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_drawerlayout);

        mToolbar = findViewById(R.id.toolBar);
        mToolbar.setTitle("凤凰新闻");
        mViewPager = findViewById(R.id.viewPager);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.dl_main_drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nv_main);

        if (navigationView != null){

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setChecked(true);
                    String title = item.getTitle().toString();
                    Toast.makeText(DrawerLayoutActivity.this, title, Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;
                }
            });

        }

        initViewPager();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home :
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
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

        FragmentAdapter mFragmentAdapteradapter =
                new FragmentAdapter(getSupportFragmentManager(), fragmentList, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);

    }
}

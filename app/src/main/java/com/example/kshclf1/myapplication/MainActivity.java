package com.example.kshclf1.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kshclf1.myapplication.adapter.HomePageAdapter;
import com.example.kshclf1.myapplication.widget.CustomTabLayout;
import com.example.kshclf1.myapplication.widget.NoScrollViewPager;


public class MainActivity extends AppCompatActivity {
    public NoScrollViewPager viewPager;
    private CustomTabLayout tabLayout;
    private HomePageAdapter homePageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        homePageAdapter = new HomePageAdapter(getSupportFragmentManager(), this);   //初始化adapter
        viewPager = (NoScrollViewPager) findViewById(R.id.viewPager);   //绑定
        viewPager.setNoScroll(true);    //设置禁止滑动
        viewPager.setAdapter(homePageAdapter);  //setAdapter
        viewPager.setOffscreenPageLimit(5);     //设置缓存
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {    //viewPager切换监听
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.select(homePageAdapter, tabLayout.getTabAt(position));    //切换tab
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout = (CustomTabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);    //绑定viewPager和tabLayout（很重要）
        tabLayout.setTabMode(TabLayout.MODE_FIXED); //设置模式
        tabLayout.initCustomView(homePageAdapter);  //初始化自定义布局
    }


}

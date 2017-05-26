package com.example.kshclf1.myapplication.widget;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.kshclf1.myapplication.adapter.HomePageAdapter;


public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context) {
        super(context);
        init(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
    }


    public void initCustomView(final HomePageAdapter homePageAdapter) {
        int i = 0;
        while (i < getTabCount()) {
            final TabLayout.Tab tab = getTabAt(i);
            tab.setCustomView(homePageAdapter.setTabView(i));
            Log.d("tag","set---"+i);
            tab.getCustomView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    select(homePageAdapter, tab);

                }
            });
            i++;
        }
        homePageAdapter.selectView(getTabAt(0).getCustomView(), 0); //选择第一个
    }

    /**
     * 选择tab
     *
     * @param homePageAdapter
     * @param tab
     */
    public void select(HomePageAdapter homePageAdapter, Tab tab) {
        for (int i = 0; i < getTabCount(); i++) {   //重置
            getTabAt(i).setCustomView(homePageAdapter.resetView(getTabAt(i).getCustomView(), i));

        }
        homePageAdapter.selectView(tab.getCustomView(), tab.getPosition());
        tab.select();
    }

}

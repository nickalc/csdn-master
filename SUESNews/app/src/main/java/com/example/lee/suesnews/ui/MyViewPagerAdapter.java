package com.example.lee.suesnews.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.lee.suesnews.ui.fragments.NewsListFragment;

import java.util.List;

/**
 *
 * Created by Administrator on 2015/2/7.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"全部","移动开发","Web前端","架构设计","编程语言","互联网","数据库","系统运维","云计算","研发管理","综合"};
    List<NewsListFragment> mList;
    public MyViewPagerAdapter(FragmentManager fm, List<NewsListFragment> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}

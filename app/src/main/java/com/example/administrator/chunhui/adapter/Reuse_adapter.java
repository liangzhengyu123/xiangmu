package com.example.administrator.chunhui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Reuse_adapter extends FragmentPagerAdapter {

    private List<String> mStringList;
    private List<Fragment> mFragmentList;

    public Reuse_adapter(FragmentManager fm, List<String> stringList, List<Fragment> fragmentList) {
        super(fm);
        mStringList = stringList;
        mFragmentList = fragmentList;
    }

    public Reuse_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStringList.get(position);
    }
}

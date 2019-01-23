package com.example.administrator.chunhui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VpAdapter extends FragmentPagerAdapter{
    private List<Fragment>fragments = new ArrayList<>();
    private List<String>tab = new ArrayList<>();

    public VpAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tab) {
        super(fm);
        this.fragments = fragments;
        this.tab = tab;
    }

    public VpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}

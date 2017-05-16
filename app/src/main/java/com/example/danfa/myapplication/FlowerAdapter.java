package com.example.danfa.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.danfa.myapplication.model.Flower;

import java.util.ArrayList;

/**
 * Created by danfa on 15/05/2017.
 */
public class FlowerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Flower> flowers;

    public FlowerAdapter(FragmentManager fm, ArrayList<Flower> flowers) {
        super(fm);
        this.flowers = flowers;
    }

    @Override
    public Fragment getItem(int position) {
        position = position % flowers.size();
        return  BlankFragment.getInstance(flowers.get(position));
    }

    @Override
    public int getCount() {
        return flowers.size() * 2;
    }
}

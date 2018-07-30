package com.example.a.dailynote;

import android.support.v4.app.FragmentStatePagerAdapter;

class pagerAdapter extends FragmentStatePagerAdapter
{
    public pagerAdapter(android.support.v4.app.FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                return new StartFirstFragment();
            case 1:
                return new StartSecondFragment();
            case 2:
                return new StartThirdFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount()
    {
        return 3;
    }
}



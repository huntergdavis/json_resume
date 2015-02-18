package com.hunterdavis.jsonresumeviewer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by hunter on 2/18/15.
 */
public class ResumePagerAdapter extends FragmentPagerAdapter {

    Context adapterContext;

    public ResumePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        adapterContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return BasicResumeFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return adapterContext.getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return adapterContext.getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return adapterContext.getString(R.string.title_section3).toUpperCase(l);
        }
        return null;
    }
}

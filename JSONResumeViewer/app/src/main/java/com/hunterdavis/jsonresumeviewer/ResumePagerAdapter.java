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
        return BasicResumeFragment.newInstance(ResumeSections.fromOrdinal(position));
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 11;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        ResumeSections section = ResumeSections.fromOrdinal(position);

        switch (section) {
            case BASICS:
                return adapterContext.getString(R.string.title_basics).toUpperCase(l);
            case AWARDS:
                return adapterContext.getString(R.string.title_awards).toUpperCase(l);
            case EDUCATION:
                return adapterContext.getString(R.string.title_education).toUpperCase(l);
            case INTERESTS:
                return adapterContext.getString(R.string.title_interests).toUpperCase(l);
            case LANGUAGES:
                return adapterContext.getString(R.string.title_languages).toUpperCase(l);
            case PUBLICATIONS:
                return adapterContext.getString(R.string.title_publications).toUpperCase(l);
            case REFERENCES:
                return adapterContext.getString(R.string.title_references).toUpperCase(l);
            case SKILLS:
                return adapterContext.getString(R.string.title_skills).toUpperCase(l);
            case VOLUNTEER:
                return adapterContext.getString(R.string.title_volunteer).toUpperCase(l);
            case WORK:
                return adapterContext.getString(R.string.title_work).toUpperCase(l);
            case PROFILES:
                return adapterContext.getString(R.string.title_profiles).toUpperCase(l);
        }
        return null;
    }
}

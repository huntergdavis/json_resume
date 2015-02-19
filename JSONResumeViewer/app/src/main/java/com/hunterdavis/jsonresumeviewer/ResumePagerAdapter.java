package com.hunterdavis.jsonresumeviewer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hunterdavis.jsonresumeviewer.fragment.AwardsFragment;
import com.hunterdavis.jsonresumeviewer.fragment.BasicsResumeFragment;
import com.hunterdavis.jsonresumeviewer.fragment.EducationFragment;
import com.hunterdavis.jsonresumeviewer.fragment.InterestsFragment;
import com.hunterdavis.jsonresumeviewer.fragment.LanguagesFragment;
import com.hunterdavis.jsonresumeviewer.fragment.ProfileFragment;
import com.hunterdavis.jsonresumeviewer.fragment.PublicationsFragment;
import com.hunterdavis.jsonresumeviewer.fragment.ReferencesFragment;
import com.hunterdavis.jsonresumeviewer.fragment.SkillsFragment;
import com.hunterdavis.jsonresumeviewer.fragment.TextResumeFragment;
import com.hunterdavis.jsonresumeviewer.fragment.VolunteerFragment;
import com.hunterdavis.jsonresumeviewer.fragment.WorkFragment;
import com.hunterdavis.jsonresumeviewer.types.Interests;
import com.hunterdavis.jsonresumeviewer.types.Publications;

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

        ResumeSections section = ResumeSections.fromOrdinal(position);

        switch (section) {

            case BASICS:
                return BasicsResumeFragment.newInstance();
            case AWARDS:
                return AwardsFragment.newInstance();
            case EDUCATION:
                return EducationFragment.newInstance();
            case INTERESTS:
                return InterestsFragment.newInstance();
            case LANGUAGES:
                return LanguagesFragment.newInstance();
            case PUBLICATIONS:
                return PublicationsFragment.newInstance();
            case REFERENCES:
                return ReferencesFragment.newInstance();
            case SKILLS:
                return SkillsFragment.newInstance();
            case VOLUNTEER:
                return VolunteerFragment.newInstance();
            case WORK:
                return WorkFragment.newInstance();
            case PROFILES:
                return ProfileFragment.newInstance();
        }

            // return our basic resume fragment
            return TextResumeFragment.newInstance(section);
        }

    @Override
    public int getCount() {
        if(JsonResumeActivity.resume == null) {
            return 1;
        }
        return 11;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        ResumeSections section = ResumeSections.fromOrdinal(position);

        switch (section) {
            case BASICS:
                if(JsonResumeActivity.resume == null) {
                    return adapterContext.getString(R.string.title_load).toUpperCase(l);
                }else {
                    return adapterContext.getString(R.string.title_basics).toUpperCase(l);
                }
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

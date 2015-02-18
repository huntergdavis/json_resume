package com.hunterdavis.jsonresumeviewer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hunterdavis.jsonresumeviewer.JsonResumeActivity;
import com.hunterdavis.jsonresumeviewer.R;
import com.hunterdavis.jsonresumeviewer.ResumeSections;

/**
 * Created by hunter on 2/18/15.
 */
public class TextResumeFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private int sectionNumber = 0;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TextResumeFragment newInstance(ResumeSections sectionNumber) {
        TextResumeFragment fragment = new TextResumeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber.ordinal());
        fragment.setArguments(args);
        return fragment;
    }

    public TextResumeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_json_resume, container, false);

        Bundle arguments = getArguments();
        sectionNumber = arguments.getInt(ARG_SECTION_NUMBER,0);

        TextView resumeText = (TextView) rootView.findViewById(R.id.resumeText);
        resumeText.setText(getTextForSection(sectionNumber));

        return rootView;
    }

    public String getTextForSection(int sectionNumber) {
        if(JsonResumeActivity.resume == null) {
            return "";
        }

        ResumeSections section = ResumeSections.fromOrdinal(sectionNumber);

        switch (section) {
            case BASICS:
                if(JsonResumeActivity.resume.getBasics() != null) {
                    return JsonResumeActivity.resume.getBasics().toString();
                }
                break;
            case AWARDS:
                if(JsonResumeActivity.resume.getAwards() != null) {
                    return JsonResumeActivity.resume.getAwardsListTextually().toString();
                }
                break;
            case EDUCATION:
                if(JsonResumeActivity.resume.getEducation() != null) {
                    return JsonResumeActivity.resume.getEducationListTextually().toString();
                }
                break;
            case INTERESTS:
                if(JsonResumeActivity.resume.getInterests() != null) {
                    return JsonResumeActivity.resume.getInterestListTextually().toString();
                }
                break;
            case LANGUAGES:
                if(JsonResumeActivity.resume.getLanguages() != null) {
                    return JsonResumeActivity.resume.getLanguages().toString();
                }
                break;
            case PUBLICATIONS:
                if(JsonResumeActivity.resume.getPublications() != null) {
                    return JsonResumeActivity.resume.getPublicationsListTextually().toString();
                }
                break;
            case REFERENCES:
                if(JsonResumeActivity.resume.getReferences() != null) {
                    return JsonResumeActivity.resume.getReferencesListTextually().toString();
                }
                break;
            case SKILLS:
                if(JsonResumeActivity.resume.getSkills() != null) {
                    return JsonResumeActivity.resume.getSkillsListTextually().toString();
                }
                break;
            case VOLUNTEER:
                if(JsonResumeActivity.resume.getVolunteer() != null) {
                    return JsonResumeActivity.resume.getVolunteerListTextually().toString();
                }
                break;
            case WORK:
                if(JsonResumeActivity.resume.getWork() != null) {
                    return JsonResumeActivity.resume.getWorkListTextually().toString();
                }
                break;
            case PROFILES:
                if(JsonResumeActivity.resume.getBasics() != null) {
                    if(JsonResumeActivity.resume.getBasics().getProfiles() != null)
                    return JsonResumeActivity.resume.getBasics().getProfilesListTextually();
                }
                break;
        }
        return "";
    }
}
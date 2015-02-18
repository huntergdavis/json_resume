package com.hunterdavis.jsonresumeviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hunterdavis.jsonresumeviewer.types.Resume;

/**
 * Created by hunter on 2/18/15.
 */
public class BasicResumeFragment  extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    Resume resume = null;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BasicResumeFragment newInstance(int sectionNumber) {
        BasicResumeFragment fragment = new BasicResumeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public BasicResumeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_json_resume, container, false);

        TextView resumeText = (TextView) rootView.findViewById(R.id.resumeText);
        if(JsonResumeActivity.resume != null) {
            resumeText.setText(resume.toString());
        }

        return rootView;
    }
}
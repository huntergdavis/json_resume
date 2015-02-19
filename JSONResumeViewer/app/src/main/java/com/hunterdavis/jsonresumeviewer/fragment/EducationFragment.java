package com.hunterdavis.jsonresumeviewer.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hunterdavis.jsonresumeviewer.JsonResumeActivity;
import com.hunterdavis.jsonresumeviewer.R;
import com.hunterdavis.jsonresumeviewer.types.Awards;
import com.hunterdavis.jsonresumeviewer.types.Education;

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class EducationFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EducationFragment newInstance() {
        EducationFragment fragment = new EducationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public EducationFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getEducation() != null) {
                EducationAdapter adapter = new EducationAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getEducation());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class EducationAdapter extends ArrayAdapter<Education> {

        public EducationAdapter(Context context, List<Education> items) {
            super(context, R.layout.education_list_item, items);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final WorkViewHolder viewHolder;
            if (convertView == null) {
                // inflate the GridView item layout
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.education_list_item, parent, false);
                // initialize the view holder
                viewHolder = new WorkViewHolder();
                viewHolder.area = (TextView) convertView.findViewById(R.id.area);
                viewHolder.startAndEndDate = (TextView) convertView.findViewById(R.id.startAndEndDate);
                viewHolder.gpa = (TextView) convertView.findViewById(R.id.gpa);
                viewHolder.institution = (TextView) convertView.findViewById(R.id.institution);
                viewHolder.courses = (TextView) convertView.findViewById(R.id.courses);
                viewHolder.studytype = (TextView) convertView.findViewById(R.id.studyType);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // update the item view
            final Education item = getItem(position);

            viewHolder.area.setText(item.getArea());
            viewHolder.startAndEndDate.setText(item.getStartDate() + " " + getString(R.string.through) + " " + item.getEndDate());
            viewHolder.gpa.setText(item.getGpa());
            viewHolder.institution.setText(item.getInstitution());
            viewHolder.courses.setText(item.getCoursesListTextually());
            viewHolder.studytype.setText(item.getStudyType());

            return convertView;
        }

    }


    /**
     * convenience viewHolder pattern
     */
    private class WorkViewHolder {
        TextView area;
        TextView institution;
        TextView startAndEndDate;
        TextView gpa;
        TextView courses;
        TextView studytype;
    }
}

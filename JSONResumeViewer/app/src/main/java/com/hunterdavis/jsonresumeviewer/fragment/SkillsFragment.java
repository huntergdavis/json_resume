package com.hunterdavis.jsonresumeviewer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hunterdavis.jsonresumeviewer.JsonResumeActivity;
import com.hunterdavis.jsonresumeviewer.R;
import com.hunterdavis.jsonresumeviewer.types.References;
import com.hunterdavis.jsonresumeviewer.types.Skills;

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class SkillsFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SkillsFragment newInstance() {
        SkillsFragment fragment = new SkillsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SkillsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getSkills() != null) {
                SkillsAdapter adapter = new SkillsAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getSkills());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class SkillsAdapter extends ArrayAdapter<Skills> {

        public SkillsAdapter(Context context, List<Skills> items) {
            super(context, R.layout.two_line_list_item, items);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final WorkViewHolder viewHolder;
            if (convertView == null) {
                // inflate the GridView item layout
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.two_line_list_item, parent, false);
                // initialize the view holder
                viewHolder = new WorkViewHolder();
                viewHolder.nameAndLevel = (TextView) convertView.findViewById(R.id.name);
                viewHolder.keywords = (TextView) convertView.findViewById(R.id.keywords);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // update the item view
            final Skills item = getItem(position);

            String nameAndLevelString = "";
            if(!TextUtils.isEmpty(item.getName())) {
                nameAndLevelString += item.getName();
            }
            if(!TextUtils.isEmpty(item.getLevel())) {
                nameAndLevelString += " (" + item.getLevel() + ")";
            }

            if(!TextUtils.isEmpty(nameAndLevelString)) {
                viewHolder.nameAndLevel.setText(nameAndLevelString);
            }

            if(!TextUtils.isEmpty(item.getKeywordListTextually())) {
                viewHolder.keywords.setText(item.getKeywordListTextually());
            }

            return convertView;
        }
    }


    /**
     * convenience viewHolder pattern
     */
    private class WorkViewHolder {
        TextView nameAndLevel;
        TextView keywords;

    }
}

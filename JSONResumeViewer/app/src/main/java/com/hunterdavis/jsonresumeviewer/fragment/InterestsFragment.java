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
import com.hunterdavis.jsonresumeviewer.types.Interests;

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class InterestsFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static InterestsFragment newInstance() {
        InterestsFragment fragment = new InterestsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public InterestsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getInterests() != null) {
                InterestsAdapter adapter = new InterestsAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getInterests());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class InterestsAdapter extends ArrayAdapter<Interests> {

        public InterestsAdapter(Context context, List<Interests> items) {
            super(context, R.layout.interests_list_item, items);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final WorkViewHolder viewHolder;
            if (convertView == null) {
                // inflate the GridView item layout
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.award_list_item, parent, false);
                // initialize the view holder
                viewHolder = new WorkViewHolder();
                viewHolder.name = (TextView) convertView.findViewById(R.id.name);
                viewHolder.keywords = (TextView) convertView.findViewById(R.id.keywords);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // update the item view
            final Interests item = getItem(position);

            viewHolder.name.setText(item.getName());
            viewHolder.keywords.setText(item.getKeywordListTextually());

            return convertView;
        }
    }


    /**
     * convenience viewHolder pattern
     */
    private class WorkViewHolder {
        TextView name;
        TextView keywords;

    }
}

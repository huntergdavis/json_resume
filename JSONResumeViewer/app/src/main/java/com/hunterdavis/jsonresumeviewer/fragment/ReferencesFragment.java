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

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class ReferencesFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ReferencesFragment newInstance() {
        ReferencesFragment fragment = new ReferencesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ReferencesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getReferences() != null) {
                ReferencesAdapter adapter = new ReferencesAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getReferences());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class ReferencesAdapter extends ArrayAdapter<References> {

        public ReferencesAdapter(Context context, List<References> items) {
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
                viewHolder.name = (TextView) convertView.findViewById(R.id.name);
                viewHolder.reference = (TextView) convertView.findViewById(R.id.keywords);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // update the item view
            final References item = getItem(position);

            if(!TextUtils.isEmpty(item.getName())) {
                viewHolder.name.setText(item.getName());
            }
            if(!TextUtils.isEmpty(item.getReference())) {
                viewHolder.reference.setText(item.getReference());
            }

            return convertView;
        }
    }


    /**
     * convenience viewHolder pattern
     */
    private class WorkViewHolder {
        TextView name;
        TextView reference;

    }
}

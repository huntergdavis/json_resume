package com.hunterdavis.jsonresumeviewer.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.hunterdavis.jsonresumeviewer.types.Awards;
import com.hunterdavis.jsonresumeviewer.types.Interests;
import com.hunterdavis.jsonresumeviewer.types.Languages;

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class LanguagesFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LanguagesFragment newInstance() {
        LanguagesFragment fragment = new LanguagesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public LanguagesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getLanguages() != null) {
                LanguagesAdapter adapter = new LanguagesAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getLanguages());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class LanguagesAdapter extends ArrayAdapter<Languages> {

        public LanguagesAdapter(Context context, List<Languages> items) {
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
                viewHolder.language = (TextView) convertView.findViewById(R.id.name);
                viewHolder.fluency = (TextView) convertView.findViewById(R.id.keywords);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // update the item view
            final Languages item = getItem(position);

            if(!TextUtils.isEmpty(item.getFluency())) {
                viewHolder.fluency.setText(item.getFluency());
            }
            if(!TextUtils.isEmpty(item.getLanguage())) {
                viewHolder.language.setText(item.getLanguage());
            }

            return convertView;
        }
    }


    /**
     * convenience viewHolder pattern
     */
    private class WorkViewHolder {
        TextView language;
        TextView fluency;

    }
}

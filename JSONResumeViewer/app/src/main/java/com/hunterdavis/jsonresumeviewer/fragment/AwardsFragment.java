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

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class AwardsFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static AwardsFragment newInstance() {
        AwardsFragment fragment = new AwardsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AwardsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getAwards() != null) {
                AwardsAdapter adapter = new AwardsAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getAwards());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class AwardsAdapter extends ArrayAdapter<Awards> {

        public AwardsAdapter(Context context, List<Awards> items) {
            super(context, R.layout.work_list_item, items);
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
                viewHolder.awarder = (TextView) convertView.findViewById(R.id.awarder);
                viewHolder.date = (TextView) convertView.findViewById(R.id.date);
                viewHolder.summary = (TextView) convertView.findViewById(R.id.summary);
                viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // update the item view
            final Awards item = getItem(position);

            if(!TextUtils.isEmpty(item.getAwarder())) {
                viewHolder.awarder.setText(item.getAwarder());
            }else {
                viewHolder.awarder.setText("");
            }
            if(!TextUtils.isEmpty(item.getDate())) {
                viewHolder.date.setText(item.getDate());
            }else {
                viewHolder.date.setText("");
            }
            if(!TextUtils.isEmpty(item.getSummary())) {
                viewHolder.summary.setText(item.getSummary());
            }else {
                viewHolder.summary.setText("");
            }
            if(!TextUtils.isEmpty(item.getTitle())) {
                viewHolder.title.setText(item.getTitle());
            }else {
                viewHolder.title.setText("");
            }

            return convertView;
        }

        private View.OnClickListener getGoToWebsiteOnclickListener(final String url) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }
            };
        }

    }


    /**
     * convenience viewHolder pattern
     */
    private class WorkViewHolder {
        TextView date;
        TextView awarder;
        TextView summary;
        TextView title;

    }
}

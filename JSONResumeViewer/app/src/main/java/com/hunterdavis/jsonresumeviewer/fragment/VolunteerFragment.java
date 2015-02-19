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
import android.widget.ImageView;
import android.widget.TextView;

import com.hunterdavis.jsonresumeviewer.IconDownloadTask;
import com.hunterdavis.jsonresumeviewer.JsonResumeActivity;
import com.hunterdavis.jsonresumeviewer.R;
import com.hunterdavis.jsonresumeviewer.types.Volunteer;
import com.hunterdavis.jsonresumeviewer.types.Work;

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class VolunteerFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static VolunteerFragment newInstance() {
        VolunteerFragment fragment = new VolunteerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public VolunteerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getVolunteer() != null) {
                VolunteerAdapter adapter = new VolunteerAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getVolunteer());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class VolunteerAdapter extends ArrayAdapter<Volunteer> {

        public VolunteerAdapter(Context context, List<Volunteer> items) {
            super(context, R.layout.work_list_item, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final WorkViewHolder viewHolder;
            if (convertView == null) {
                // inflate the GridView item layout
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.work_list_item, parent, false);
                // initialize the view holder
                viewHolder = new WorkViewHolder();
                viewHolder.workImageAndWebsiteLauncher = (ImageView) convertView.findViewById(R.id.websiteIconimageButton);
                viewHolder.businessName = (TextView) convertView.findViewById(R.id.businessName);
                viewHolder.jobTitle = (TextView) convertView.findViewById(R.id.jobTitle);
                viewHolder.startAndEndDate = (TextView) convertView.findViewById(R.id.startAndEndDate);
                viewHolder.summary = (TextView) convertView.findViewById(R.id.summary);
                viewHolder.highlights = (TextView) convertView.findViewById(R.id.highlights);
                convertView.setTag(viewHolder);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // hide the image
            viewHolder.workImageAndWebsiteLauncher.setVisibility(View.GONE);

            // update the item view
            final Volunteer item = getItem(position);

            if(!TextUtils.isEmpty(item.getWebsite())) {
                viewHolder.workImageAndWebsiteLauncher.setOnClickListener(getGoToWebsiteOnclickListener(item.getWebsite()));
                viewHolder.businessName.setOnClickListener(getGoToWebsiteOnclickListener(item.getWebsite()));

                final String favIconString = item.getWebsite() + "/favicon.ico";

                new IconDownloadTask(viewHolder.workImageAndWebsiteLauncher).execute(favIconString);
            }

            if(!TextUtils.isEmpty(item.getOrganization())) {
                viewHolder.businessName.setText(item.getOrganization());
            }

            if(!TextUtils.isEmpty(item.getPosition())) {
                viewHolder.jobTitle.setText(item.getPosition());
            }

            if(!TextUtils.isEmpty(item.getStartDate())) {
                if(!TextUtils.isEmpty(item.getEndDate())) {
                    viewHolder.startAndEndDate.setText("" + item.getStartDate() + " " + getString(R.string.through) + " " + item.getEndDate());
                }
            }

            if(!TextUtils.isEmpty(item.getSummary())) {
                viewHolder.summary.setText(item.getSummary());
            }

            if(!TextUtils.isEmpty(item.getHighlightListTextually())) {
                viewHolder.highlights.setText(item.getHighlightListTextually());
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
        ImageView workImageAndWebsiteLauncher;
        TextView businessName;
        TextView jobTitle;
        TextView startAndEndDate;
        TextView summary;
        TextView highlights;

    }
}

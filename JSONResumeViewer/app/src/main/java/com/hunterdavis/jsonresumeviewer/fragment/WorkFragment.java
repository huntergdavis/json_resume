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
import com.hunterdavis.jsonresumeviewer.types.Work;

import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class WorkFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static WorkFragment newInstance() {
        WorkFragment fragment = new WorkFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public WorkFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getWork() != null) {
                WorkAdapter adapter = new WorkAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getWork());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class WorkAdapter extends ArrayAdapter<Work> {

        public WorkAdapter(Context context, List<Work> items) {
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
            final Work item = getItem(position);

            if(!TextUtils.isEmpty(item.getWebsite())) {
                viewHolder.workImageAndWebsiteLauncher.setOnClickListener(getGoToWebsiteOnclickListener(item.getWebsite()));
                viewHolder.businessName.setOnClickListener(getGoToWebsiteOnclickListener(item.getWebsite()));

                final String favIconString = item.getWebsite() + "/favicon.ico";

                new IconDownloadTask(viewHolder.workImageAndWebsiteLauncher).execute(favIconString);
            }

            if(!TextUtils.isEmpty(item.getCompany())) {
                viewHolder.businessName.setText(item.getCompany());
            }else {
                viewHolder.businessName.setText("");
            }

            if(!TextUtils.isEmpty(item.getPosition())) {
                viewHolder.jobTitle.setText(item.getPosition());
            }else {
                viewHolder.jobTitle.setText("");
            }

            if(!TextUtils.isEmpty(item.getStartDate())) {
             if(!TextUtils.isEmpty(item.getEndDate())) {
                 viewHolder.startAndEndDate.setText("" + item.getStartDate() + " " + getString(R.string.through) + " " + item.getEndDate());
             }
            }

            if(!TextUtils.isEmpty(item.getSummary())) {
                viewHolder.summary.setText(item.getSummary());
            }else {
                viewHolder.summary.setText("");
            }

            if(!TextUtils.isEmpty(item.getHighlightListTextually())) {
                viewHolder.highlights.setText(item.getHighlightListTextually());
            }else {
                viewHolder.highlights.setText("");
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

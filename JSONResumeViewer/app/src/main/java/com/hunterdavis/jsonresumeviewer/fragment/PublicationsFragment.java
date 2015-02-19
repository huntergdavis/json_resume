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
import com.hunterdavis.jsonresumeviewer.types.Awards;
import com.hunterdavis.jsonresumeviewer.types.Publications;
import com.hunterdavis.jsonresumeviewer.types.Work;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class PublicationsFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PublicationsFragment newInstance() {
        PublicationsFragment fragment = new PublicationsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public PublicationsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getPublications() != null) {
                PublicationsAdapter adapter = new PublicationsAdapter(
                        inflater.getContext(), JsonResumeActivity.resume.getPublications());
                setListAdapter(adapter);
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class PublicationsAdapter extends ArrayAdapter<Publications> {

        public PublicationsAdapter(Context context, List<Publications> items) {
            super(context, R.layout.publications_list_item, items);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final WorkViewHolder viewHolder;
            if (convertView == null) {
                // inflate the GridView item layout
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.publications_list_item, parent, false);
                // initialize the view holder
                viewHolder = new WorkViewHolder();
                viewHolder.name = (TextView) convertView.findViewById(R.id.businessName);
                viewHolder.websiteIcon = (ImageView) convertView.findViewById(R.id.websiteIconimageButton);
                viewHolder.website = (TextView) convertView.findViewById(R.id.website);
                viewHolder.publisher = (TextView) convertView.findViewById(R.id.publisher);
                viewHolder.summary = (TextView) convertView.findViewById(R.id.summary);
                viewHolder.releaseDate = (TextView) convertView.findViewById(R.id.releaseDate);
                convertView.setTag(viewHolder);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // hide the image
            viewHolder.websiteIcon.setVisibility(View.GONE);

            // update the item view
            final Publications item = getItem(position);

            if(!TextUtils.isEmpty(item.getWebsite())) {
                viewHolder.websiteIcon.setOnClickListener(getGoToWebsiteOnclickListener(item.getWebsite()));
                viewHolder.name.setOnClickListener(getGoToWebsiteOnclickListener(item.getWebsite()));

                String baseURL = item.getWebsite();
                try
                {
                    URL url = new URL(item.getWebsite());
                    baseURL = url.getProtocol() + "://" + url.getHost();
                }
                catch (MalformedURLException e)
                {
                    // do something
                }

                final String favIconString = baseURL + "/favicon.ico";

                new IconDownloadTask(viewHolder.websiteIcon).execute(favIconString);
            }

            if(!TextUtils.isEmpty(item.getName())) {
                viewHolder.name.setText(item.getName());
            }

            if(!TextUtils.isEmpty(item.getWebsite())) {
                viewHolder.website.setText(item.getWebsite());
            }

            if(!TextUtils.isEmpty(item.getPublisher())) {
                if(!TextUtils.isEmpty(item.getPublisher())) {
                    viewHolder.publisher.setText(item.getPublisher());
                }
            }

            if(!TextUtils.isEmpty(item.getSummary())) {
                viewHolder.summary.setText(item.getSummary());
            }

            if(!TextUtils.isEmpty(item.getReleaseDate())) {
                viewHolder.releaseDate.setText(item.getReleaseDate());
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
        ImageView websiteIcon;
        TextView name;
        TextView releaseDate;
        TextView publisher;
        TextView summary;
        TextView website;
    }
}

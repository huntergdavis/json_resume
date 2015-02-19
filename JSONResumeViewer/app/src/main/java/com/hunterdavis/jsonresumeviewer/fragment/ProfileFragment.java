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
import com.hunterdavis.jsonresumeviewer.types.Profiles;
import com.hunterdavis.jsonresumeviewer.types.Work;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by hunter on 2/18/15.
 */
public class ProfileFragment extends ListFragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(JsonResumeActivity.resume != null) {
            if (JsonResumeActivity.resume.getBasics() != null) {
                if(JsonResumeActivity.resume.getBasics().getProfiles() != null) {
                    ProfilesAdapter adapter = new ProfilesAdapter(
                            inflater.getContext(), JsonResumeActivity.resume.getBasics().getProfiles());
                    setListAdapter(adapter);
                }
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class ProfilesAdapter extends ArrayAdapter<Profiles> {

        public ProfilesAdapter(Context context, List<Profiles> items) {
            super(context, R.layout.profile_list_item, items);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final WorkViewHolder viewHolder;
            if (convertView == null) {
                // inflate the GridView item layout
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.profile_list_item, parent, false);
                // initialize the view holder
                viewHolder = new WorkViewHolder();
                viewHolder.workImageAndWebsiteLauncher = (ImageView) convertView.findViewById(R.id.websiteIconimageButton);
                viewHolder.network = (TextView) convertView.findViewById(R.id.network);
                viewHolder.username = (TextView) convertView.findViewById(R.id.userName);
                viewHolder.website = (TextView) convertView.findViewById(R.id.website);
                convertView.setTag(viewHolder);
            } else {
                // recycle the already inflated view
                viewHolder = (WorkViewHolder) convertView.getTag();
            }

            // hide the image
            viewHolder.workImageAndWebsiteLauncher.setVisibility(View.GONE);

            // update the item view
            final Profiles item = getItem(position);

            if(!TextUtils.isEmpty(item.getUrl())) {
                viewHolder.workImageAndWebsiteLauncher.setOnClickListener(getGoToWebsiteOnclickListener(item.getUrl()));
                viewHolder.network.setOnClickListener(getGoToWebsiteOnclickListener(item.getUrl()));
                viewHolder.website.setOnClickListener(getGoToWebsiteOnclickListener(item.getUrl()));

                viewHolder.website.setText(item.getUrl());

                String baseURL = item.getUrl();
                try
                {
                    URL url = new URL(item.getUrl());
                    baseURL = url.getProtocol() + "://" + url.getHost();
                }
                catch (MalformedURLException e)
                {
                    // do something.. or not
                }

                final String favIconString = baseURL + "/favicon.ico";

                new IconDownloadTask(viewHolder.workImageAndWebsiteLauncher).execute(favIconString);
            }

            if(!TextUtils.isEmpty(item.getUsername())) {
                viewHolder.username.setText(item.getUsername());
            }

            if(!TextUtils.isEmpty(item.getNetwork())) {
                viewHolder.network.setText(item.getNetwork());
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
        TextView network;
        TextView username;
        TextView website;

    }
}

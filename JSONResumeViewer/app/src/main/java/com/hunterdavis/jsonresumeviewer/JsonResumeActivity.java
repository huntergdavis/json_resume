package com.hunterdavis.jsonresumeviewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hunterdavis.jsonresumeviewer.types.Resume;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;


public class JsonResumeActivity extends ActionBarActivity implements ActionBar.TabListener {

    // our pager adapter
    ResumePagerAdapter mResumePagerAdapter;
    ViewPager mViewPager;

    public static Resume resume = null;
    public static OkHttpClient client = null;

    private static boolean ignoreIntent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_resume);

        Intent intent = getIntent();
        String action = intent.getAction();

        if(ignoreIntent) {
            ignoreIntent = false;
        }else {
            if (action.compareTo(Intent.ACTION_VIEW) == 0) {
                String scheme = intent.getScheme();
                ContentResolver resolver = getContentResolver();

                if (scheme.compareTo(ContentResolver.SCHEME_FILE) == 0) {
                    Uri uri = intent.getData();

                    boolean intentResolutionFailed = false;
                    InputStream input = null;
                    try {
                        input = resolver.openInputStream(uri);
                    } catch (FileNotFoundException e) {
                        intentResolutionFailed = true;
                    }
                    try {
                        resume = JsonResumeParser.parseInputStreamForJsonResume(input);
                    } catch (UnsupportedEncodingException e) {
                        intentResolutionFailed = true;
                    }

                    if (!intentResolutionFailed) {
                        // this.recreate();
                    }
                }
            }
        }


        // implement our okhttp cache for work page.. ugh ico files..!
        int cacheSize = 1024 * 1024; // 1 MiB
        File cacheDirectory = new File(getCacheDir().getAbsolutePath(), "HttpCache");
        Cache cache = null;
        try {
            cache = new Cache(cacheDirectory, cacheSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client = new OkHttpClient();
        client.setCache(cache);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mResumePagerAdapter = new ResumePagerAdapter(getSupportFragmentManager(), this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mResumePagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mResumePagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mResumePagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }

        // just a little niceness
        if(resume != null) {
            if(resume.getBasics() != null) {
                if(!TextUtils.isEmpty(resume.getBasics().getName())) {
                    getSupportActionBar().setTitle(resume.getBasics().getName());
                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_json_resume, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_hunter) {

            try {
                resume = JsonResumeParser.parseHuntersResume(this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // recreate everything
            ignoreIntent = true;
            this.recreate();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

}

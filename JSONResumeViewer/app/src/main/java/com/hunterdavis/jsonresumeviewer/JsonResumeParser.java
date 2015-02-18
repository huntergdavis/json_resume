package com.hunterdavis.jsonresumeviewer;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.hunterdavis.jsonresumeviewer.types.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by hunter on 2/18/15.
 */
public class JsonResumeParser {

    /**
     * parse Hunter's current resume from the assets folder
     * @param context
     * @return
     */
    public static Resume parseHuntersResume(Context context) throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream;
        inputStream = assetManager.open("resume.json");
        return parseInputStreamForJsonResume(inputStream);
    }

    /**
     * parse an inputstream for a Resume object
     * @param input
     * @return
     */
    public static Resume parseInputStreamForJsonResume(InputStream input) throws UnsupportedEncodingException {

        JsonReader reader = new JsonReader(new InputStreamReader(input, "UTF-8"));
        Gson gson = new Gson();
        Resume resume = gson.fromJson(reader, Resume.class);

        return resume;
    }
}

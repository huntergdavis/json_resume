package com.hunterdavis.jsonresumeviewer;

/**
 * Created by hunter on 2/18/15.
 */
public enum ResumeSections {
    BASICS,
    AWARDS,
    EDUCATION,
    INTERESTS,
    LANGUAGES,
    PUBLICATIONS,
    REFERENCES,
    SKILLS,
    VOLUNTEER,
    WORK,
    PROFILES;

    private static ResumeSections[] allValues = values();
    public static ResumeSections fromOrdinal(int n) {return allValues[n];}
}

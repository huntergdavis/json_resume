package com.hunterdavis.jsonresumeviewer;

/**
 * resume sections for the tab adapter
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

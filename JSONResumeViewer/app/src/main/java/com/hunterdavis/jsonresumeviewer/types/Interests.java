
package com.hunterdavis.jsonresumeviewer.types;

import android.text.TextUtils;

import java.util.List;

public class Interests{
   	private List<String> keywords;
   	private String name;

    @Override
    public String toString() {
        return "Interests{" +
                "keywords=" + getKeywordListTextually() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getKeywordListTextually() {
        return TextUtils.join(",",keywords);
    }

    public List getKeywords(){
		return this.keywords;
	}
	public void setKeywords(List keywords){
		this.keywords = keywords;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}

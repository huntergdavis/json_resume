
package com.hunterdavis.jsonresumeviewer.types;

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
        String ret = "";

        if(keywords != null) {
            for (String keyword : keywords) {
                ret += (keyword.toString() + "," + '\'');
            }
        }

        return ret;
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


package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class Awards{
   	private String awarder;
   	private String date;
   	private String summary;
   	private String title;

 	public String getAwarder(){
		return this.awarder;
	}
	public void setAwarder(String awarder){
		this.awarder = awarder;
	}
 	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date = date;
	}
 	public String getSummary(){
		return this.summary;
	}
	public void setSummary(String summary){
		this.summary = summary;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
}

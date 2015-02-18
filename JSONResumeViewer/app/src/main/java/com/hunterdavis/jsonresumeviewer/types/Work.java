
package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class Work{
   	private String company;
   	private String endDate;
   	private List highlights;
   	private String position;
   	private String startDate;
   	private String summary;
   	private String website;

 	public String getCompany(){
		return this.company;
	}
	public void setCompany(String company){
		this.company = company;
	}
 	public String getEndDate(){
		return this.endDate;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
 	public List getHighlights(){
		return this.highlights;
	}
	public void setHighlights(List highlights){
		this.highlights = highlights;
	}
 	public String getPosition(){
		return this.position;
	}
	public void setPosition(String position){
		this.position = position;
	}
 	public String getStartDate(){
		return this.startDate;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
 	public String getSummary(){
		return this.summary;
	}
	public void setSummary(String summary){
		this.summary = summary;
	}
 	public String getWebsite(){
		return this.website;
	}
	public void setWebsite(String website){
		this.website = website;
	}
}

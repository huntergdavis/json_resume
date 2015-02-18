
package com.hunterdavis.jsonresume.types;

import java.util.List;

public class Publications{
   	private String name;
   	private String publisher;
   	private String releaseDate;
   	private String summary;
   	private String website;

 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getPublisher(){
		return this.publisher;
	}
	public void setPublisher(String publisher){
		this.publisher = publisher;
	}
 	public String getReleaseDate(){
		return this.releaseDate;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
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

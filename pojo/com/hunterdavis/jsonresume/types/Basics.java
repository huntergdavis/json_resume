
package com.hunterdavis.jsonresume.types;

import java.util.List;

public class Basics{
   	private String email;
   	private String label;
   	private Location location;
   	private String name;
   	private String phone;
   	private String picture;
   	private List profiles;
   	private String summary;
   	private String website;

 	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
 	public String getLabel(){
		return this.label;
	}
	public void setLabel(String label){
		this.label = label;
	}
 	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
 	public String getPicture(){
		return this.picture;
	}
	public void setPicture(String picture){
		this.picture = picture;
	}
 	public List getProfiles(){
		return this.profiles;
	}
	public void setProfiles(List profiles){
		this.profiles = profiles;
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


package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class Resume{
   	private List awards;
   	private Basics basics;
   	private List education;
   	private List interests;
   	private List languages;
   	private List publications;
   	private List references;
   	private List skills;
   	private List volunteer;
   	private List work;

 	public List getAwards(){
		return this.awards;
	}
	public void setAwards(List awards){
		this.awards = awards;
	}
 	public Basics getBasics(){
		return this.basics;
	}
	public void setBasics(Basics basics){
		this.basics = basics;
	}
 	public List getEducation(){
		return this.education;
	}
	public void setEducation(List education){
		this.education = education;
	}
 	public List getInterests(){
		return this.interests;
	}
	public void setInterests(List interests){
		this.interests = interests;
	}
 	public List getLanguages(){
		return this.languages;
	}
	public void setLanguages(List languages){
		this.languages = languages;
	}
 	public List getPublications(){
		return this.publications;
	}
	public void setPublications(List publications){
		this.publications = publications;
	}
 	public List getReferences(){
		return this.references;
	}
	public void setReferences(List references){
		this.references = references;
	}
 	public List getSkills(){
		return this.skills;
	}
	public void setSkills(List skills){
		this.skills = skills;
	}
 	public List getVolunteer(){
		return this.volunteer;
	}
	public void setVolunteer(List volunteer){
		this.volunteer = volunteer;
	}
 	public List getWork(){
		return this.work;
	}
	public void setWork(List work){
		this.work = work;
	}
}

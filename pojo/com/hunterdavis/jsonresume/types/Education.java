
package com.hunterdavis.jsonresume.types;

import java.util.List;

public class Education{
   	private String area;
   	private List courses;
   	private String endDate;
   	private String gpa;
   	private String institution;
   	private String startDate;
   	private String studyType;

 	public String getArea(){
		return this.area;
	}
	public void setArea(String area){
		this.area = area;
	}
 	public List getCourses(){
		return this.courses;
	}
	public void setCourses(List courses){
		this.courses = courses;
	}
 	public String getEndDate(){
		return this.endDate;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
 	public String getGpa(){
		return this.gpa;
	}
	public void setGpa(String gpa){
		this.gpa = gpa;
	}
 	public String getInstitution(){
		return this.institution;
	}
	public void setInstitution(String institution){
		this.institution = institution;
	}
 	public String getStartDate(){
		return this.startDate;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
 	public String getStudyType(){
		return this.studyType;
	}
	public void setStudyType(String studyType){
		this.studyType = studyType;
	}
}

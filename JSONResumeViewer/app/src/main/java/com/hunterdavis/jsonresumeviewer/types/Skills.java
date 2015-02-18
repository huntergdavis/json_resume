
package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class Skills{
   	private List keywords;
   	private String level;
   	private String name;

 	public List getKeywords(){
		return this.keywords;
	}
	public void setKeywords(List keywords){
		this.keywords = keywords;
	}
 	public String getLevel(){
		return this.level;
	}
	public void setLevel(String level){
		this.level = level;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}


package com.hunterdavis.jsonresume.types;

import java.util.List;

public class Interests{
   	private List keywords;
   	private String name;

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


package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class Languages{
   	private String fluency;
   	private String language;

    @Override
    public String toString() {
        return "Languages{" +
                "fluency='" + fluency + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public String getFluency(){
		return this.fluency;
	}
	public void setFluency(String fluency){
		this.fluency = fluency;
	}
 	public String getLanguage(){
		return this.language;
	}
	public void setLanguage(String language){
		this.language = language;
	}
}

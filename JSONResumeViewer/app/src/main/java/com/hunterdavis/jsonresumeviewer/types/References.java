
package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class References{
   	private String name;
   	private String reference;

    @Override
    public String toString() {
        return "References{" +
                "name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }

    public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getReference(){
		return this.reference;
	}
	public void setReference(String reference){
		this.reference = reference;
	}
}


package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class Profiles{
   	private String network;
   	private String url;
   	private String username;

    @Override
    public String toString() {
        return "Profiles{" +
                "network='" + network + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getNetwork(){
		return this.network;
	}
	public void setNetwork(String network){
		this.network = network;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
}

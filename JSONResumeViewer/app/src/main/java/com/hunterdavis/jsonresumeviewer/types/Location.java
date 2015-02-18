
package com.hunterdavis.jsonresumeviewer.types;

import java.util.List;

public class Location{
   	private String address;
   	private String city;
   	private String countryCode;
   	private String postalCode;
   	private String region;

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address = address;
	}
 	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city = city;
	}
 	public String getCountryCode(){
		return this.countryCode;
	}
	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}
 	public String getPostalCode(){
		return this.postalCode;
	}
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
 	public String getRegion(){
		return this.region;
	}
	public void setRegion(String region){
		this.region = region;
	}
}

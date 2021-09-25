package com.zemoso.springdemo.mvc;

import java.util.LinkedHashMap;

/**
 * @author thilp
 *
 */
public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favLang;
	private String[] operatingSystems;
	private LinkedHashMap<String,String> countryOptions;
	Student()
	{
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("In","India");
		countryOptions.put("Ch","China");
		countryOptions.put("Us","USA");
		countryOptions.put("Uk", "United Kingdom");
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	public String getFavLang() {
		return favLang;
	}
	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
}

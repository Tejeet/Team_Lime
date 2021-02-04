package com.tejeet.tataclicq_clone.DataNModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProductDetailsDTO implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("brandname")
	private String brandname;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("price")
	private String price;

	@SerializedName("fileurl")
	private String fileurl;

	@SerializedName("other")
	private String other;

	@SerializedName("createdon")
	private String createdon;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setBrandname(String brandname){
		this.brandname = brandname;
	}

	public String getBrandname(){
		return brandname;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setFileurl(String fileurl){
		this.fileurl = fileurl;
	}

	public String getFileurl(){
		return fileurl;
	}

	public void setOther(String other){
		this.other = other;
	}

	public String getOther(){
		return other;
	}

	public void setCreatedon(String createdon){
		this.createdon = createdon;
	}

	public String getCreatedon(){
		return createdon;
	}

	@Override
 	public String toString(){
		return 
			"ProductDetailsDTO{" + 
			"id = '" + id + '\'' + 
			",brandname = '" + brandname + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",price = '" + price + '\'' + 
			",fileurl = '" + fileurl + '\'' + 
			",other = '" + other + '\'' + 
			",createdon = '" + createdon + '\'' + 
			"}";
		}
}
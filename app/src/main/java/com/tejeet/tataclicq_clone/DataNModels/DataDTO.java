package com.tejeet.tataclicq_clone.DataNModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataDTO implements Serializable {

	@SerializedName("campaign_id")
	private int campaignId;

	@SerializedName("total_call")
	private int totalCall;

	@SerializedName("total_number")
	private int totalNumber;

	@SerializedName("message")
	private String message;

	public void setCampaignId(int campaignId){
		this.campaignId = campaignId;
	}

	public int getCampaignId(){
		return campaignId;
	}

	public void setTotalCall(int totalCall){
		this.totalCall = totalCall;
	}

	public int getTotalCall(){
		return totalCall;
	}

	public void setTotalNumber(int totalNumber){
		this.totalNumber = totalNumber;
	}

	public int getTotalNumber(){
		return totalNumber;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"DataDTO{" + 
			"campaign_id = '" + campaignId + '\'' + 
			",total_call = '" + totalCall + '\'' + 
			",total_number = '" + totalNumber + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
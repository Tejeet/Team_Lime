package com.tejeet.tataclicq_clone.DataNModels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CallResponseDTO implements Serializable {

	@SerializedName("success")
	private boolean success;

	@SerializedName("error")
	private Object error;

	@SerializedName("data")
	private DataDTO data;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setError(Object error){
		this.error = error;
	}

	public Object getError(){
		return error;
	}

	public void setData(DataDTO data){
		this.data = data;
	}

	public DataDTO getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"CallResponseDTO{" + 
			"success = '" + success + '\'' + 
			",error = '" + error + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}
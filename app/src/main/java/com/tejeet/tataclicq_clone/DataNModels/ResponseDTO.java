package com.tejeet.tataclicq_clone.DataNModels;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("productDetails")
	private List<ProductDetailsDTO> productDetails;

	@SerializedName("success")
	private int success;

	public void setProductDetails(List<ProductDetailsDTO> productDetails){
		this.productDetails = productDetails;
	}

	public List<ProductDetailsDTO> getProductDetails(){
		return productDetails;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"productDetails = '" + productDetails + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}
package com.tejeet.tataclicq_clone.DataNModels;

public class MyCartModel {


    private String cid;
    private String brandName;
    private String productName;
    private String price;
    private String description;
    private String fileUrl;

    public MyCartModel(String cid, String brandName, String productName, String price, String description, String fileUrl) {
        this.cid = cid;
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.fileUrl = fileUrl;
    }

    public String getCid() {
        return cid;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getFileUrl() {
        return fileUrl;
    }
}

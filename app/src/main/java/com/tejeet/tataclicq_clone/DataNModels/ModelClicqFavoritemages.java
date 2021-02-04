package com.tejeet.tataclicq_clone.DataNModels;

public class ModelClicqFavoritemages {

    private int imageID;
    private String category;

    public ModelClicqFavoritemages(int imageID, String category) {

        this.imageID = imageID;
        this.category = category;
    }

    public int getImageID() {
        return imageID;
    }

    public String getCategory() {
        return category;
    }
}

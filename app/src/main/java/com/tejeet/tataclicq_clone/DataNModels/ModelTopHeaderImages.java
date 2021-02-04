package com.tejeet.tataclicq_clone.DataNModels;

public class ModelTopHeaderImages {

    private int imageID;
    private String category;

    public ModelTopHeaderImages(int imageID, String category) {
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

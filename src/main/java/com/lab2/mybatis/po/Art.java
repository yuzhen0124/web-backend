package com.lab2.mybatis.po;

public class Art {
    private int artID;
    private String artName;
    private String description;

    public Art(int artID, String artName, String description) {
        this.artID = artID;
        this.artName = artName;
        this.description = description;
    }

    public Art(String artName, String description) {
        this.artName = artName;
        this.description = description;
    }

    public int getArtID() {
        return artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public String getArtName() {
        return artName;
    }
    public void setArtName(String artName) {

        this.artName = artName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

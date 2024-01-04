package com.classwork.hm4_3.continets;

public class ContinentModel {

    private String name;
    private String img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ContinentModel(String name, String img) {
        this.name = name;
        this.img = img;
    }
}

package com.codekul.nestedlayouts;

/**
 * Created by aniruddha on 28/11/16.
 */

public class Avenger {

    private String name;
    private int image;
    private String info;

    public Avenger(String name , int image, String info){
        this.name = name;
        this.image = image;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

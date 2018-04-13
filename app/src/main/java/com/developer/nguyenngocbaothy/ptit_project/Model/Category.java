package com.developer.nguyenngocbaothy.ptit_project.Model;

/**
 * Created by Dell on 3/12/2018.
 */

public class Category {
    private String id;
    private String name;
    private int image;

    public Category() {
    }

    public Category(String id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}

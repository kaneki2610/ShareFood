package com.developer.nguyenngocbaothy.ptit_project.Model;

import java.io.Serializable;

/**
 * Created by Dell on 3/12/2018.
 */

public class Product {
    private String id;
    private String parent_id;
    private String name;
    private String image;

    public Product() {
    }

    public Product(String id, String parent_id, String name) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
    }

    public Product(String id, String parent_id, String name, String image) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

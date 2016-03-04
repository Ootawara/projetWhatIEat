package com.epsi.whatieat.Model;

/**
 * Created by Florent on 16/02/2016.
 */
public class Food {

    String name, description, id;
    public Food(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}
}

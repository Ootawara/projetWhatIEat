package com.epsi.whatieat.Model;

/**
 * Created by tamiand on 03/03/2016.
 */
public class Component {

    String name, description, effects;
    public Component(){

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

    public String getEffects() { return effects; }

    public void setEffects(String effects) { this.effects = effects; }
}

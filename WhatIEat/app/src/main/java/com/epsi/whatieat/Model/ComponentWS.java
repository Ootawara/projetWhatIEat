package com.epsi.whatieat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tamiand on 03/03/2016.
 */
public class ComponentWS {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("effects")
    @Expose
    private String effects;

    @SerializedName("id")
    @Expose
    private String id;

    /**
     *
     * @return
     * The Name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * (Required)
     *
     * @param name
     * The Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }
    /**
     *
     * (Required)
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *
     * (Required)
     *
     * @param effects
     * The effects
     */
    public void setEffects(String effects) { this.effects = effects; }
    /**
     *
     * @return
     * The effects
     */
    public String getEffects() {
        return effects;
    }

    /**
     *
     * (Required)
     *
     * @param id
     * The id
     */
    public void setId(String id) {this.id = id;}
    /**
     *
     * @return
     * The id
     */
    public String getId() {return id;}

}

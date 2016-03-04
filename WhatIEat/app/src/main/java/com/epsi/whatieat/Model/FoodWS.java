package com.epsi.whatieat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Florent on 04/02/2016.
 */
public class FoodWS {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

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

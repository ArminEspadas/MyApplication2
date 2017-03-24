package com.fiuady.db;

/**
 * Created by Armín on 17/03/2017.
 */
public class Category {

    private  int id;
    private String description;

    public  Category (int id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

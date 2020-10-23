package com.irisa.obiee.backforfront.obieeservices;

import javax.persistence.Id;

public class Report {

    @Id
    private Integer id;
    private String caption;
    private String description;
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}

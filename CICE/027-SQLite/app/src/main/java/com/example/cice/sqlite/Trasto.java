package com.example.cice.sqlite;

/**
 * Created by CICE on 19/1/16.
 */
public class Trasto {

    long id;
    String name;

    public Trasto() {
    }

    public Trasto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

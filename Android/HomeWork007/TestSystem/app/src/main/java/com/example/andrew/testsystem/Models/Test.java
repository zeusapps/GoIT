package com.example.andrew.testsystem.Models;

/**
 * Created by Andrew on 18.12.2016.
 */

public class Test {
    public static final String ID_FIELD = "id";
    public static final String NAME_FIELD = "name";
    public static final String IMAGE_FIELD = "image";


    private String _name;
    private String _image;
    private long _id;

    public Test(
            int id,
            String name,
            String image){
        this._id = id;
        this._name = name;
        this._image = image;
    }

    public Test(
            String name,
            String image) {
        this(-1, name, image);
    }

    public String getName() {
        return _name;
    }

    public String getImage() {
        return _image;
    }

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }
}

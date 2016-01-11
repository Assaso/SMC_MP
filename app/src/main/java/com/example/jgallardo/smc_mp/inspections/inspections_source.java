package com.example.jgallardo.smc_mp.inspections;


public class inspections_source {

    private String add_item;
    private int add_image;

    public inspections_source(String add_item, int add_image){
        this.add_item = add_item;
        this.add_image = add_image;
    }

    public String getAdd_item(){
        return add_item;
    }

    public int getAdd_image(){
        return add_image;
    }
}

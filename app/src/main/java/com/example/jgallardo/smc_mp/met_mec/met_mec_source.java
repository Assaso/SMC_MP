package com.example.jgallardo.smc_mp.met_mec;

public class met_mec_source {

    private String add_item;
    private int add_color;

    public met_mec_source (String add_item, int add_color){
        this.add_item = add_item;
        this.add_color = add_color;
    }

    public String getAdd_item(){
        return add_item;
    }

    public int getAdd_color(){
        return add_color;
    }
}


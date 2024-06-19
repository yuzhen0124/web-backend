package com.example.demo.mybatis.po;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Art {
    private int artID;
    private String artName;
    private String description;

    public Art(int artID, String artName, String description) {
        this.artID = artID;
        this.artName = artName;
        this.description = description;
    }

    public Art(String artName, String description) {
        this.artName = artName;
        this.description = description;
    }

}

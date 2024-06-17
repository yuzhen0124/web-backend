package com.lab2.controller;

import com.google.gson.Gson;
import com.lab2.mybatis.po.Art;
import com.lab2.request.Art.ArtAddRequest;
import com.lab2.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/art")
public class ArtController {
    @Autowired
    private ArtService artService;

    @GetMapping("/all")
    public String getAll() {
        try {
            List<Art> arts = artService.findAllArts();
            if(arts.isEmpty()){
                return "no art";
            } else {
                Gson gson = new Gson();
                return gson.toJson(arts);
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/{artID}")
    public String findArt(@PathVariable int artID) {
        try {
            Art art = artService.getArt(artID);
            if (art == null) {
                return "no art";
            } else {
                Gson gson = new Gson();
                return gson.toJson(art);
            }
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @PostMapping("/add")
    public String addArt(@RequestBody ArtAddRequest request) {
        try {
            Art art = new Art(request.getArtName(), request.getDescription());
            return artService.insertArt(art);
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }


}

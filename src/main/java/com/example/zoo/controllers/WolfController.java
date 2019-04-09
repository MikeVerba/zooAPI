package com.example.zoo.controllers;

import com.example.zoo.api.models.WolfDto;
import com.example.zoo.services.WolfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(WolfController.BASE_URL)
public class WolfController {
    public static final String BASE_URL = "api/v1/wolves";

    WolfServiceImpl wolfService;

    @Autowired
    public WolfController(WolfServiceImpl wolfService) {
        this.wolfService = wolfService;
    }

    @GetMapping
    public ResponseEntity<List<WolfDto>> getAllWolves(){
        return new ResponseEntity<List<WolfDto>>(wolfService.getAllWolfs(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<WolfDto> getWolfById(@PathVariable Long id){
        return new ResponseEntity<WolfDto>(wolfService.getWolfById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<WolfDto> createNewWolf(@RequestBody WolfDto wolfDto){
        return new ResponseEntity<WolfDto>(wolfService.createNewWolf(wolfDto),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<WolfDto> saveWolfById(@PathVariable Long id,@RequestBody WolfDto wolfDto){
        return new ResponseEntity<WolfDto>(wolfService.saveWolfById(id,wolfDto),HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<WolfDto> patchWolf(@PathVariable Long id, @RequestBody WolfDto wolfDto){
        return new ResponseEntity<WolfDto>(wolfService.patchWolf(id,wolfDto),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteWolf(@PathVariable Long id){
        wolfService.deleteWolf(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

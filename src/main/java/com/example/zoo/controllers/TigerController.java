package com.example.zoo.controllers;

import com.example.zoo.api.models.TigerDto;
import com.example.zoo.services.TigerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(TigerController.BASE_URL)
public class TigerController {
    public static final String BASE_URL = "api/v1/tigers";

    TigerServiceImpl tigerService;

    @Autowired
    public TigerController(TigerServiceImpl tigerService) {
        this.tigerService = tigerService;
    }

    @GetMapping
    public ResponseEntity<List<TigerDto>> getAllTigers(){
        return new ResponseEntity<List<TigerDto>>(tigerService.getAllTigers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TigerDto> getTigerById(@PathVariable Long id){
        return new ResponseEntity<TigerDto>(tigerService.getTigerById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TigerDto> createNewTiger(@RequestBody TigerDto tigerDto){
        return new ResponseEntity<TigerDto>(tigerService.createNewTiger(tigerDto),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<TigerDto> saveTigerById(@PathVariable Long id, @RequestBody TigerDto tigerDto){
        return new ResponseEntity<TigerDto>(tigerService.saveTigerById(id,tigerDto),HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<TigerDto> patchTiger(@PathVariable Long id,@RequestBody TigerDto tigerDto){
        return new ResponseEntity<TigerDto>(tigerService.patchTiger(id,tigerDto),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTiger(@PathVariable Long id){
        tigerService.deleteTiger(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

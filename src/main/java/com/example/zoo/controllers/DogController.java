package com.example.zoo.controllers;

import com.example.zoo.api.models.DogDto;
import com.example.zoo.services.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(DogController.BASE_URL)
public class DogController {

    public static final String BASE_URL = "api/v1/dogs";

    DogServiceImpl dogService;

    @Autowired
    public DogController(DogServiceImpl dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<DogDto>> getAllDogs(){
        return new ResponseEntity<List<DogDto>>(dogService.getAllDogs(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DogDto> getDogById(@PathVariable Long id){
        return new ResponseEntity<DogDto>(dogService.getDogById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DogDto> createNewDog(@RequestBody DogDto dogDto){
        return new ResponseEntity<DogDto>(dogService.createNewDog(dogDto),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<DogDto> saveDogById(@PathVariable Long id,@RequestBody DogDto dogDto){
        return new ResponseEntity<DogDto>(dogService.saveDogById(id,dogDto),HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<DogDto> patchDog(@PathVariable Long id, @RequestBody DogDto dogDto){
        return new ResponseEntity<DogDto>(dogService.patchDog(id,dogDto),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id){
        dogService.deleteDog(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

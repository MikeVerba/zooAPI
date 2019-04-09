package com.example.zoo.controllers;

import com.example.zoo.api.models.BearDto;
import com.example.zoo.services.BearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(BearController.BASE_URL)
public class BearController {

    BearServiceImpl bearService;

    @Autowired
    public BearController(BearServiceImpl bearService) {
        this.bearService = bearService;
    }

    public static final String BASE_URL = "api/v1/bears";

    @GetMapping
    public ResponseEntity<List<BearDto>> getAllBears(){
        return new ResponseEntity<List<BearDto>>(bearService.getAllBears(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BearDto> getBearById(@PathVariable Long id){
        return new ResponseEntity<BearDto>(bearService.getBearById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<BearDto> createNewBear(@RequestBody BearDto bearDto){
        return new ResponseEntity<BearDto>(bearService.createNewBear(bearDto),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<BearDto> saveBearById(@PathVariable Long id,@RequestBody BearDto bearDto){
        return new ResponseEntity<BearDto>(bearService.saveBearById(id,bearDto),HttpStatus.OK);
    }
    @PatchMapping("{id}")
    public ResponseEntity<BearDto> patchBear(@PathVariable Long id,@RequestBody BearDto bearDto){
        return new ResponseEntity<BearDto>(bearService.patchBear(id,bearDto),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBear(@PathVariable Long id){
        bearService.deleteBear(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

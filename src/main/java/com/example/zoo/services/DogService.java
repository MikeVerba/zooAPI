package com.example.zoo.services;

import com.example.zoo.api.models.DogDto;

import java.util.List;

public interface DogService {

    List<DogDto> getAllDogs();

    DogDto getDogById(Long id);

    DogDto createNewDog(DogDto dogDto);

    DogDto saveDogById(Long id,DogDto dogDto);

    DogDto patchDog(Long id, DogDto dogDto);

    void deleteDog(Long id);
}

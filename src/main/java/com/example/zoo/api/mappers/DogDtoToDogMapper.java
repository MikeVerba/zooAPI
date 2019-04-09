package com.example.zoo.api.mappers;

import com.example.zoo.api.models.DogDto;
import com.example.zoo.domain.Dog;
import org.springframework.stereotype.Service;

@Service
public class DogDtoToDogMapper implements Mapper<DogDto, Dog> {
    @Override
    public Dog map(DogDto key) {
        Dog dog = new Dog();

        dog.setId(key.getId());
        dog.setName(key.getName());
        dog.setWeight(key.getWeight());

        return dog;
    }
}

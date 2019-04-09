package com.example.zoo.api.mappers;

import com.example.zoo.api.models.DogDto;
import com.example.zoo.domain.Dog;
import org.springframework.stereotype.Service;

@Service
public class DogToDogDtoMapper implements Mapper<Dog, DogDto> {
    @Override
    public DogDto map(Dog key) {
        DogDto dogDto = new DogDto();

        dogDto.setId(key.getId());
        dogDto.setName(key.getName());
        dogDto.setWeight(key.getWeight());

        return dogDto;
    }
}

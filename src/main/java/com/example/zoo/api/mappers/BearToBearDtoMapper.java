package com.example.zoo.api.mappers;

import com.example.zoo.api.models.BearDto;
import com.example.zoo.domain.Bear;
import org.springframework.stereotype.Service;

@Service
public class BearToBearDtoMapper implements Mapper<Bear,BearDto> {
    @Override
    public BearDto map(Bear key) {

        BearDto bearDto = new BearDto();

        bearDto.setId(key.getId());
        bearDto.setName(key.getName());
        bearDto.setWeight(key.getWeight());
        bearDto.setFurLength(key.getFurLength());

        return bearDto;
    }
}

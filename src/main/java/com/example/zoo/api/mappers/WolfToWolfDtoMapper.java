package com.example.zoo.api.mappers;

import com.example.zoo.api.models.WolfDto;
import com.example.zoo.domain.Wolf;
import org.springframework.stereotype.Service;

@Service
public class WolfToWolfDtoMapper implements Mapper<Wolf, WolfDto> {
    @Override
    public WolfDto map(Wolf key) {
        WolfDto wolfDto = new WolfDto();

        wolfDto.setId(key.getId());
        wolfDto.setName(key.getName());
        wolfDto.setWeight(key.getWeight());
        wolfDto.setFangLength(key.getFangLength());

        return wolfDto;
    }
}

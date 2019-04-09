package com.example.zoo.api.mappers;

import com.example.zoo.api.models.BearDto;
import com.example.zoo.domain.Bear;
import org.springframework.stereotype.Service;

@Service
public class BearDtoToBearMapper implements Mapper<BearDto, Bear> {
    @Override
    public Bear map(BearDto key) {


        Bear bear = new Bear();

        bear.setId(key.getId());
        bear.setName(key.getName());
        bear.setWeight(key.getWeight());
        bear.setFurLength(key.getFurLength());

        return bear;

    }
}

package com.example.zoo.api.mappers;

import com.example.zoo.api.models.WolfDto;
import com.example.zoo.domain.Wolf;
import org.springframework.stereotype.Service;

@Service
public class WolfDtoToWolfMapper implements Mapper<WolfDto, Wolf> {
    @Override
    public Wolf map(WolfDto key) {
        Wolf wolf = new Wolf();

        wolf.setId(key.getId());
        wolf.setName(key.getName());
        wolf.setWeight(key.getWeight());
        wolf.setFangLength(key.getFangLength());

        return wolf;
    }
}

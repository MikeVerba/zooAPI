package com.example.zoo.api.mappers;

import com.example.zoo.api.models.TigerDto;
import com.example.zoo.domain.Tiger;
import org.springframework.stereotype.Service;

@Service
public class TigerDtoToTigerMapper implements Mapper<TigerDto, Tiger> {
    @Override
    public Tiger map(TigerDto key) {
        Tiger tiger = new Tiger();

        tiger.setId(key.getId());
        tiger.setName(key.getName());
        tiger.setWeight(key.getWeight());
        tiger.setClawLength(key.getClawLength());

        return tiger;
    }
}

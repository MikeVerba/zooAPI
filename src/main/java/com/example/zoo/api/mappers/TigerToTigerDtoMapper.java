package com.example.zoo.api.mappers;

import com.example.zoo.api.models.TigerDto;
import com.example.zoo.domain.Tiger;
import org.springframework.stereotype.Service;

@Service
public class TigerToTigerDtoMapper implements Mapper<Tiger, TigerDto> {
    @Override
    public TigerDto map(Tiger key) {
        TigerDto tigerDto = new TigerDto();

        tigerDto.setId(key.getId());
        tigerDto.setName(key.getName());
        tigerDto.setWeight(key.getWeight());
        tigerDto.setClawLength(key.getClawLength());

        return tigerDto;
    }
}

package com.example.zoo.services;

import com.example.zoo.api.models.BearDto;

import java.util.List;

public interface BearService {

    List<BearDto> getAllBears();

    BearDto getBearById(Long id);

    BearDto createNewBear(BearDto bearDto);

    BearDto saveBearById(Long id,BearDto bearDto);

    BearDto patchBear(Long id,BearDto bearDto);

    void deleteBear(Long id);
}

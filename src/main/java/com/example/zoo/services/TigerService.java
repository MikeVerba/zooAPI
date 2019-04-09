package com.example.zoo.services;

import com.example.zoo.api.models.TigerDto;

import java.util.List;

public interface TigerService {

    List<TigerDto> getAllTigers();

    TigerDto getTigerById(Long id);

    TigerDto createNewTiger(TigerDto dogDto);

    TigerDto saveTigerById(Long id,TigerDto dogDto);

    TigerDto patchTiger(Long id, TigerDto dogDto);

    void deleteTiger(Long id);


}

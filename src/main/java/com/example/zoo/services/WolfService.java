package com.example.zoo.services;

import com.example.zoo.api.models.WolfDto;

import java.util.List;

public interface WolfService {

    List<WolfDto> getAllWolfs();

    WolfDto getWolfById(Long id);

    WolfDto createNewWolf(WolfDto wolfDto);

    WolfDto saveWolfById(Long id, WolfDto wolfDto);

    WolfDto patchWolf(Long id, WolfDto wolfDto);

    void deleteWolf(Long id);
}

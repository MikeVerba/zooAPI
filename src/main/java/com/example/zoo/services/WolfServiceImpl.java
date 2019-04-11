package com.example.zoo.services;

import com.example.zoo.api.mappers.WolfDtoToWolfMapper;
import com.example.zoo.api.mappers.WolfToWolfDtoMapper;
import com.example.zoo.api.models.WolfDto;
import com.example.zoo.controllers.WolfController;
import com.example.zoo.domain.Tiger;
import com.example.zoo.domain.Wolf;
import com.example.zoo.repositories.WolfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WolfServiceImpl implements WolfService {

    private final WolfRepository wolfRepository;
    private final WolfDtoToWolfMapper wolfDtoToWolfMapper;
    private final WolfToWolfDtoMapper wolfToWolfDtoMapper;

    @Autowired
    public WolfServiceImpl(WolfRepository wolfRepository, WolfDtoToWolfMapper wolfDtoToWolfMapper, WolfToWolfDtoMapper wolfToWolfDtoMapper) {
        this.wolfRepository = wolfRepository;
        this.wolfDtoToWolfMapper = wolfDtoToWolfMapper;
        this.wolfToWolfDtoMapper = wolfToWolfDtoMapper;
    }

    @Override
    public List<WolfDto> getAllWolfs() {
        return wolfRepository.findAll()
                .stream()
                .map(wolf -> {

                    WolfDto wolfDto = wolfToWolfDtoMapper.map(wolf);
                    wolfDto.setWolfUrl(getWolfUrl(wolf.getId()));
                    return wolfDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public WolfDto getWolfById(Long id) {
        return wolfRepository.findById(id)
                .map(wolf -> {
                    WolfDto wolfDto = wolfToWolfDtoMapper.map(wolf);
                    wolfDto.setWolfUrl(getWolfUrl(wolf.getId()));
                    return wolfDto;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public WolfDto createNewWolf(WolfDto wolfDto) {

        Wolf wolf = wolfDtoToWolfMapper.map(wolfDto);
        Wolf savedWolf = wolfRepository.save(wolf);
        WolfDto returnDto = wolfToWolfDtoMapper.map(savedWolf);
        returnDto.setWolfUrl(getWolfUrl(savedWolf.getId()));

        return returnDto;
    }

    @Override
    public WolfDto saveWolfById(Long id, WolfDto wolfDto) {

        Wolf wolf = wolfDtoToWolfMapper.map(wolfDto);
        wolf.setId(id);
        Wolf savedWolf = wolfRepository.save(wolf);
        WolfDto returnDto = wolfToWolfDtoMapper.map(savedWolf);
        returnDto.setWolfUrl(getWolfUrl(id));

        return returnDto;
    }

    @Override
    public WolfDto patchWolf(Long id, WolfDto wolfDto) {
        return wolfRepository.findById(id)
                .map(wolf -> {

                    if(wolfDto.getName() != null){
                        wolf.setName(wolfDto.getName());

                    }
                    if(wolfDto.getWeight() != null){
                        wolf.setWeight(wolf.getWeight());

                    }
                    if(wolfDto.getFangLength() != null){
                        wolf.setFangLength(wolfDto.getFangLength());

                    }

                    Wolf savedWolf = wolfRepository.save(wolf);

                    WolfDto returnDto = wolfToWolfDtoMapper.map(savedWolf);
                    returnDto.setWolfUrl(getWolfUrl(id));
                    return returnDto;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteWolf(Long id) {
        wolfRepository.deleteById(id);
    }

    private String getWolfUrl(Long id){
        return WolfController.BASE_URL + "/" + id;
    }
}

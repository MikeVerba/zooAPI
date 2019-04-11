package com.example.zoo.services;

import com.example.zoo.api.mappers.TigerDtoToTigerMapper;
import com.example.zoo.api.mappers.TigerToTigerDtoMapper;
import com.example.zoo.api.models.TigerDto;
import com.example.zoo.controllers.TigerController;
import com.example.zoo.domain.Tiger;
import com.example.zoo.repositories.TigerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TigerServiceImpl implements TigerService {

    private final TigerRepository tigerRepository;
    private final TigerDtoToTigerMapper tigerDtoToTigerMapper;
    private final TigerToTigerDtoMapper tigerToTigerDtoMapper;

    @Autowired
    public TigerServiceImpl(TigerRepository tigerRepository, TigerDtoToTigerMapper tigerDtoToTigerMapper, TigerToTigerDtoMapper tigerToTigerDtoMapper) {
        this.tigerRepository = tigerRepository;
        this.tigerDtoToTigerMapper = tigerDtoToTigerMapper;
        this.tigerToTigerDtoMapper = tigerToTigerDtoMapper;
    }

    @Override
    public List<TigerDto> getAllTigers() {
        return tigerRepository.findAll()
                .stream()
                .map(tiger -> {
                    TigerDto tigerDto = tigerToTigerDtoMapper.map(tiger);
                    tigerDto.setTigerUrl(getTigerUrl(tiger.getId()));
                    return tigerDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TigerDto getTigerById(Long id) {
        return tigerRepository.findById(id)
                .map(tiger -> {
                    TigerDto tigerDto = tigerToTigerDtoMapper.map(tiger);
                    tigerDto.setTigerUrl(getTigerUrl(tiger.getId()));
                    return tigerDto;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public TigerDto createNewTiger(TigerDto tigerDto) {

        Tiger tiger = tigerDtoToTigerMapper.map(tigerDto);
        Tiger savedTiger = tigerRepository.save(tiger);
        TigerDto returnDto = tigerToTigerDtoMapper.map(savedTiger);
        returnDto.setTigerUrl(getTigerUrl(savedTiger.getId()));

        return returnDto;
    }

    @Override
    public TigerDto saveTigerById(Long id, TigerDto tigerDto) {

        Tiger tiger = tigerDtoToTigerMapper.map(tigerDto);
        tiger.setId(id);
        Tiger savedTiger = tigerRepository.save(tiger);
        TigerDto returnDto = tigerToTigerDtoMapper.map(savedTiger);
        returnDto.setTigerUrl(getTigerUrl(id));

        return returnDto;
    }

    @Override
    public TigerDto patchTiger(Long id, TigerDto tigerDto) {
        return tigerRepository.findById(id)
                .map(tiger -> {

                    if(tigerDto.getName() != null){
                        tiger.setName(tigerDto.getName());

                    }
                    if(tigerDto.getWeight() != null){
                        tiger.setWeight(tigerDto.getWeight());

                    }
                    if(tigerDto.getClawLength() != null){
                        tiger.setClawLength(tigerDto.getClawLength());

                    }

                    Tiger savedTiger = tigerRepository.save(tiger);


                    TigerDto returnDto = tigerToTigerDtoMapper.map(savedTiger);
                    returnDto.setTigerUrl(getTigerUrl(id));
                    return returnDto;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteTiger(Long id) {
        tigerRepository.deleteById(id);
    }

    private String getTigerUrl(Long id){
        return TigerController.BASE_URL + "/" + id;
    }
}

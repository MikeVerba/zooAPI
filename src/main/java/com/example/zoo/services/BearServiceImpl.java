package com.example.zoo.services;

import com.example.zoo.api.mappers.BearDtoToBearMapper;
import com.example.zoo.api.mappers.BearToBearDtoMapper;
import com.example.zoo.api.models.BearDto;
import com.example.zoo.controllers.BearController;
import com.example.zoo.domain.Bear;
import com.example.zoo.repositories.BearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BearServiceImpl implements BearService {

    private final BearRepository bearRepository;
    private final BearDtoToBearMapper bearDtoToBearMapper;
    private final BearToBearDtoMapper bearToBearDtoMapper;

    @Autowired
    public BearServiceImpl(BearRepository bearRepository, BearDtoToBearMapper bearDtoToBearMapper, BearToBearDtoMapper bearToBearDtoMapper) {
        this.bearRepository = bearRepository;
        this.bearDtoToBearMapper = bearDtoToBearMapper;
        this.bearToBearDtoMapper = bearToBearDtoMapper;
    }

    @Override
    public List<BearDto> getAllBears() {
        return bearRepository.findAll()
                .stream()
                .map(bear -> {

                    BearDto bearDto = bearToBearDtoMapper.map(bear);
                    bearDto.setBearUrl(getBearUrl(bear.getId()));

                    return bearDto;

                })
                .collect(Collectors.toList());
    }

    @Override
    public BearDto getBearById(Long id) {
        return bearRepository.findById(id)
                .map(bear -> {

                    BearDto bearDto = bearToBearDtoMapper.map(bear);
                    bearDto.setBearUrl(getBearUrl(bear.getId()));
                    return bearDto;

                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public BearDto createNewBear(BearDto bearDto) {

        Bear bear = bearDtoToBearMapper.map(bearDto);
        Bear savedBear = bearRepository.save(bear);
        BearDto returnDto = bearToBearDtoMapper.map(savedBear);
        returnDto.setBearUrl(getBearUrl(savedBear.getId()));

        return returnDto;
    }

    @Override
    public BearDto saveBearById(Long id, BearDto bearDto) {

        Bear bear = bearDtoToBearMapper.map(bearDto);
        bear.setId(id);
        Bear savedBear = bearRepository.save(bear);
        BearDto returnDto = bearToBearDtoMapper.map(savedBear);
        returnDto.setBearUrl(getBearUrl(id));
        return returnDto;
    }

    @Override
    public BearDto patchBear(Long id, BearDto bearDto) {
        return bearRepository.findById(id)
                .map(bear -> {

                    if(bearDto.getName() != null){
                        bear.setName(bearDto.getName());

                    }
                    if(bearDto.getWeight() != null){
                        bear.setWeight(bearDto.getWeight());

                    }
                    if(bearDto.getFurLength() != null){
                        bear.setFurLength(bearDto.getFurLength());

                    }

                    Bear savedBear = bearRepository.save(bear);

                    BearDto returnDto = bearToBearDtoMapper.map(savedBear);
                    returnDto.setBearUrl(getBearUrl(id));
                    return returnDto;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteBear(Long id) {
        bearRepository.deleteById(id);
    }

    private String getBearUrl(Long id){
        return BearController.BASE_URL + "/" + id;
    }
}

package com.example.zoo.services;

import com.example.zoo.api.mappers.DogDtoToDogMapper;
import com.example.zoo.api.mappers.DogToDogDtoMapper;
import com.example.zoo.api.models.DogDto;
import com.example.zoo.controllers.DogController;
import com.example.zoo.domain.Dog;
import com.example.zoo.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;
    private final DogToDogDtoMapper dogToDogDtoMapper;
    private final DogDtoToDogMapper dogDtoToDogMapper;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository, DogToDogDtoMapper dogToDogDtoMapper, DogDtoToDogMapper dogDtoToDogMapper) {
        this.dogRepository = dogRepository;
        this.dogToDogDtoMapper = dogToDogDtoMapper;
        this.dogDtoToDogMapper = dogDtoToDogMapper;
    }

    @Override
    public List<DogDto> getAllDogs() {
        return dogRepository.findAll()
                .stream()
                .map(dog -> {

                    DogDto dogDto = dogToDogDtoMapper.map(dog);
                    dogDto.setDogUrl(getDogUrl(dog.getId()));
                    return dogDto;
                })
                .collect(Collectors.toList());

    }

    @Override
    public DogDto getDogById(Long id) {
        return dogRepository.findById(id)
                .map(dog -> {
                    DogDto dogDto = dogToDogDtoMapper.map(dog);
                    dogDto.setDogUrl(getDogUrl(dog.getId()));
                    return dogDto;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public DogDto createNewDog(DogDto dogDto) {

        Dog dog = dogDtoToDogMapper.map(dogDto);
        Dog savedDog = dogRepository.save(dog);
        DogDto returnDto = dogToDogDtoMapper.map(savedDog);
        returnDto.setDogUrl(getDogUrl(savedDog.getId()));

        return returnDto;
    }

    @Override
    public DogDto saveDogById(Long id, DogDto dogDto) {

        Dog dog = dogDtoToDogMapper.map(dogDto);
        dog.setId(id);
        Dog savedDog = dogRepository.save(dog);
        DogDto returnDto = dogToDogDtoMapper.map(savedDog);
        returnDto.setDogUrl(getDogUrl(id));

        return returnDto;
    }

    @Override
    public DogDto patchDog(Long id, DogDto dogDto) {
        return dogRepository.findById(id)
                .map(dog -> {

                    if(dogDto.getName() != null){
                        dog.setName(dogDto.getName());

                    }
                    if(dogDto.getWeight() != null){
                        dog.setWeight(dogDto.getWeight());

                    }

                    Dog savedDog = dogRepository.save(dog);

                    DogDto returnDto = dogToDogDtoMapper.map(savedDog);

                    returnDto.setDogUrl(getDogUrl(id));
                    return returnDto;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteDog(Long id) {

        dogRepository.deleteById(id);

    }

    private String getDogUrl(Long id){
        return DogController.BASE_URL + "/" + id;
    }
}

package com.example.zoo.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DogDto {

    private Long id;
    private String name;
    private Float weight;

    @JsonProperty("dog_url")
    private String dogUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getDogUrl() {
        return dogUrl;
    }

    public void setDogUrl(String dogUrl) {
        this.dogUrl = dogUrl;
    }
}

package com.example.zoo.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WolfDto {

    private Long id;
    private String name;
    private Float weight;
    private Integer fangLength;


    @JsonProperty("wolf_url")
    private String wolfUrl;

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

    public Integer getFangLength() {
        return fangLength;
    }

    public void setFangLength(Integer fangLength) {
        this.fangLength = fangLength;
    }

    public String getWolfUrl() {
        return wolfUrl;
    }

    public void setWolfUrl(String wolfUrl) {
        this.wolfUrl = wolfUrl;
    }
}

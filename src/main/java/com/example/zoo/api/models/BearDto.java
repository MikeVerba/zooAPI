package com.example.zoo.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BearDto {

    private Long id;
    private String name;
    private Float weight;
    private Integer furLength;

    @JsonProperty("bear_url")
    private String bearUrl;

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

    public Integer getFurLength() {
        return furLength;
    }

    public void setFurLength(Integer furLength) {
        this.furLength = furLength;
    }

    public String getBearUrl() {
        return bearUrl;
    }

    public void setBearUrl(String bearUrl) {
        this.bearUrl = bearUrl;
    }
}

package com.example.zoo.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TigerDto {
    private Long id;
    private String name;
    private Float weight;
    private Integer clawLength;

    @JsonProperty("tiger_url")
    private String tigerUrl;

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

    public Integer getClawLength() {
        return clawLength;
    }

    public void setClawLength(Integer clawLength) {
        this.clawLength = clawLength;
    }

    public String getTigerUrl() {
        return tigerUrl;
    }

    public void setTigerUrl(String tigerUrl) {
        this.tigerUrl = tigerUrl;
    }
}

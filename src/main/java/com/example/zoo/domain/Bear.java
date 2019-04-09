package com.example.zoo.domain;

import lombok.Data;

import javax.persistence.Entity;


@Entity
@Data
public class Bear extends Animal {

    private Integer furLength;


    @Override
    void introduce() {

        System.out.println("I'm a bear. My name is " + super.getName()
                +". I weight " + super.getWeight()
                + " and my fur length is "+furLength);

    }

    public Integer getFurLength() {
        return furLength;
    }

    public void setFurLength(Integer furLength) {
        this.furLength = furLength;
    }
}

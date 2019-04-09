package com.example.zoo.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Wolf extends Animal implements Canine {

    private Integer fangLength;

    @Override
    void introduce() {

        System.out.println("I'm a bear. My name is " + super.getName()
                +". I weight " + super.getWeight()
                + " and my claw length is "+fangLength);

    }

    @Override
    public void bark() {
        System.out.println("BARK BARK BARK");

    }

    public Integer getFangLength() {
        return fangLength;
    }

    public void setFangLength(Integer fangLength) {
        this.fangLength = fangLength;
    }
}

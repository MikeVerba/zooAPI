package com.example.zoo.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Tiger extends Animal {

    private Integer clawLength;


    @Override
    void introduce() {

        System.out.println("I'm a bear. My name is " + super.getName()
                +". I weight " + super.getWeight()
                + " and my claw length is "+clawLength);

    }

    public Integer getClawLength() {
        return clawLength;
    }

    public void setClawLength(Integer clawLength) {
        this.clawLength = clawLength;
    }
}

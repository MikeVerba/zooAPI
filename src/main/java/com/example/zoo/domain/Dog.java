package com.example.zoo.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Dog extends Animal implements Canine {


    @Override
    void introduce() {

        System.out.println("I'm a bear. My name is " + super.getName()
                +". I weight " + super.getWeight());

    }

    @Override
    public void bark() {
        System.out.println("bark bark bark");

    }

    void sitPretty(){
        System.out.println(super.getName() + "sits pretty");
    }
}

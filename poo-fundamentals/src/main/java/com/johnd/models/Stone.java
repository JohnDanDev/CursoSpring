package com.johnd.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

//Lombok, sustituye al cosntructor, get and set y el equals y el hashcode
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Stone implements Serializable {

    String color;
    String name;
    String location;
    Integer energyLevel;
    Integer numberOfSides;

    private static final int NUMBER_SIDES = 6;

    //Se usara un cosntructor

    public Stone(String color, String name, String location, Integer energyLevel) {
        this.color = color;
        this.name = name;
        this.location = location;
        this.energyLevel = energyLevel;
        this.numberOfSides = NUMBER_SIDES; //El número de lados no cambia para las gemas
    }

    public abstract void usePower();

    public void clear(){
        System.out.println("Clening Stone");
    }
}

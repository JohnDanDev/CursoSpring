package com.johnd.models;


import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString
@Log
public class TimeStone extends Stone{

    private static final String COLOR = "Green";
    private static final String NAME = "Time Stone";
    private static final String LOCATION = "Agamotto";
    private static final int ENERGY_LEVEL = 9;

    public TimeStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        //Toda la logica de negocio
        System.out.println("Control Time:" +super.toString()); //Automaticamente se sobre entiende que "this" agrega el valor toString
    }

    public TimeStone getPrototype(){
        try(
                final var bos = new ByteArrayOutputStream(); //biteArrayOutputStream(bos)
                final var oos = new ObjectOutputStream(bos);
        ){
            //Serializa objetos (clone)
            oos.writeObject(this);
            oos.flush();
            try(
                    final var bis = new ByteArrayInputStream(bos.toByteArray());
                    final var ois = new ObjectInputStream(bis);
            ){
                //Regresa y costea el objeto convertido
                return (TimeStone) ois.readObject();
            }


        } catch (IOException | ClassNotFoundException e) {

            log.warning("Cant`t cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}

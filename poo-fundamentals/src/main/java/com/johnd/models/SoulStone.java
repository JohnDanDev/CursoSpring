package com.johnd.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class SoulStone extends Stone{

    private static final String COLOR = "Orange";
    private static final String NAME = "Soul Stone";
    private static final String LOCATION = "Vormir";
    private static final int ENERGY_LEVEL = 6;

    public SoulStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        //Toda la logica de negocio
        System.out.println("Total control persons:" +super.toString()); //Automaticamente se sobre entiende que "this" agrega el valor toString
    }

    public SoulStone getPrototype(){
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
                return (SoulStone) ois.readObject();
            }


        } catch (IOException | ClassNotFoundException e) {

            log.warning("Cant`t cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}

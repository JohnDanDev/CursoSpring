package com.johnd.models;


import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class SpaceStone extends Stone{

    private static final String COLOR = "Blue";
    private static final String NAME = "Space Stone";
    private static final String LOCATION = "Tesseract";
    private static final int ENERGY_LEVEL = 7;

    public SpaceStone() {
        //super: Hace referencia al constructor del Padre o superclase
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);

    }

    @Override //Sobre escribe el metodo abstracto usePower
    public void usePower() {
        //Toda la logica de negocio
        System.out.println("Manipulate all space:" +super.toString()); //Automaticamente se sobre entiende que "this" agrega el valor toString
    }

    public SpaceStone getPrototype(){
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
                return (SpaceStone) ois.readObject();
            }


        } catch (IOException | ClassNotFoundException e) {

            log.warning("Cant`t cast or read class");
            throw new RuntimeException(e.getMessage());
        }
    }
}

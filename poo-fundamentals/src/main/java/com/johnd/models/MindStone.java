package com.johnd.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.*;

@ToString(callSuper = true)
@Log
public class MindStone extends Stone{

    private static final String COLOR = "Yellow";
    private static final String NAME = "Mind Stone";
    private static final String LOCATION = "Vision";
    private static final int ENERGY_LEVEL = 8;

    public MindStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        //Toda la logica de negocio
        System.out.println("Mind control in stone:" +super.toString()); //Automaticamente se sobre entiende que "super" agrega el valor de los atributos
    }

    public MindStone getPrototype(){
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
                return (MindStone) ois.readObject();
            }


        } catch (IOException | ClassNotFoundException e) {

          log.warning("Cant`t cast or read class");
          throw new RuntimeException(e.getMessage());
        }
    }
}

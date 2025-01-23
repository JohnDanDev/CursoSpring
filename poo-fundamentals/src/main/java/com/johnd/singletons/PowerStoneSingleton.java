package com.johnd.singletons;

import com.johnd.models.MindStone;
import com.johnd.models.PowerStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE) //Esto es lo mismo si ponemos un constrructor en privado
public class PowerStoneSingleton {
    private static volatile PowerStone powerStoneInstance;

    //crear metodo para acceder a la instancia
    public static PowerStone getInstance(){
        if(powerStoneInstance == null){
            log.info("Creating firs instance..." + PowerStoneSingleton.class);
            synchronized (PowerStoneSingleton.class){
                if(powerStoneInstance == null){
                    powerStoneInstance = new PowerStone();
                }
            }
        }
        return powerStoneInstance;
    }
}

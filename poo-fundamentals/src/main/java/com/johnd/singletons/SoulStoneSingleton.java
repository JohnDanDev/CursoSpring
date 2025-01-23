package com.johnd.singletons;

import com.johnd.models.MindStone;
import com.johnd.models.SoulStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE) //Esto es lo mismo si ponemos un constrructor en privado

public class SoulStoneSingleton {

    private static volatile SoulStone soulStoneInstance;

    //crear metodo para acceder a la instancia
    public static SoulStone getInstance(){
        if(soulStoneInstance == null){
            log.info("Creating firs instance..." + SoulStoneSingleton.class);
            synchronized (SoulStoneSingleton.class){
                if(soulStoneInstance == null){
                    soulStoneInstance = new SoulStone();
                }
            }
        }
        return soulStoneInstance;
    }
}

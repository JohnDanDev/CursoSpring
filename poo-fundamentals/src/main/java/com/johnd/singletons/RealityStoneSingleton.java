package com.johnd.singletons;

import com.johnd.models.RealityStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE) //Esto es lo mismo si ponemos un constrructor en privado
public class RealityStoneSingleton {
    private static volatile RealityStone realityStoneInstance;

    //crear metodo para acceder a la instancia
    public static RealityStone getInstance(){
        if(realityStoneInstance == null){
            log.info("Creating firs instance..." + RealityStoneSingleton.class);
            synchronized (RealityStoneSingleton.class){
                if(realityStoneInstance == null){
                    realityStoneInstance = new RealityStone();
                }
            }
        }
        return realityStoneInstance;
    }
}

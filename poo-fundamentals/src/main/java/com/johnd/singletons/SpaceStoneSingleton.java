package com.johnd.singletons;

import com.johnd.models.MindStone;
import com.johnd.models.SpaceStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE) //Esto es lo mismo si ponemos un constrructor en privado

public class SpaceStoneSingleton {

    private static volatile SpaceStone spaceStoneInstance;

    //crear metodo para acceder a la instancia
    public static SpaceStone getInstance(){
        if(spaceStoneInstance == null){
            log.info("Creating firs instance..." + SpaceStoneSingleton.class);
            synchronized (SpaceStoneSingleton.class){
                if(spaceStoneInstance == null){
                    spaceStoneInstance = new SpaceStone();
                }
            }
        }
        return spaceStoneInstance;
    }
}

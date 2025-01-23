package com.johnd.singletons;

import com.johnd.models.MindStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE) //Esto es lo mismo si ponemos un constrructor en privado
public class MindStoneSingleton {

    private static volatile MindStone mindStoneInstance;

    //crear metodo para acceder a la instancia
    public static MindStone getInstance(){
        if(mindStoneInstance == null){
            log.info("Creating firs instance..." + MindStoneSingleton.class);
            synchronized (MindStoneSingleton.class){
                if(mindStoneInstance == null){
                    mindStoneInstance = new MindStone();
                }
            }
        }
        return mindStoneInstance;
    }


}

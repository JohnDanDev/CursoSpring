package com.johnd.singletons;

import com.johnd.models.MindStone;
import com.johnd.models.TimeStone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE) //Esto es lo mismo si ponemos un constrructor en privado

public class TimeStoneSingleton {

    private static volatile TimeStone timeStoneInstance;

    //crear metodo para acceder a la instancia
    public static TimeStone getInstance(){
        if(timeStoneInstance == null){
            log.info("Creating firs instance..." + TimeStoneSingleton.class);
            synchronized (TimeStoneSingleton.class){
                if(timeStoneInstance == null){
                    timeStoneInstance = new TimeStone();
                }
            }
        }
        return timeStoneInstance;
    }
}

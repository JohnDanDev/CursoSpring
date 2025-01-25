package com.johnd.services;

import com.johnd.models.*;
import com.johnd.singletons.MindStoneSingleton;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.lang.reflect.Field;
import java.util.Map;

//@Service
@Log
@AllArgsConstructor
@NoArgsConstructor
public class GauntleServiceImpl implements GauntleService {


    private RealityStone reality;
    private SoulStone soul;
    private MindStone mind;
    private PowerStone power;
    private SpaceStone space;
    private TimeStone time;


    @Override
    public void useGauntle(String stoneName) {
        switch(stoneName) {
            case "reality" -> log.info("Use stone " + this.reality);
            case "soul" -> log.info("Use stone " + this.soul);
            case "mind" -> log.info("Use stone " + this.mind);
            case "power" -> log.info("Use stone " + this.power);
            case "space" -> log.info("Use stone " + this.space);
            case "time" -> log.info("Use stone " + this.time);
            default->throw new IllegalArgumentException("Invalid name");
        }
    }

   @Override
    public void useFullPower() {
        if(this.time != null && this.space != null && this.mind != null && this.reality != null && this.soul != null && this.power != null) {
            log.info("Using All Powers");
        }else{
            throw new IllegalStateException("Can´t be using full power because service have field null");
        }
    }

    //Inyeccion
    public void setStones(Map<String, Stone> stones){
        stones.forEach((fieldName, stoneDependency)->{
            try{
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, stoneDependency);
                log.info("Dependency Injection by field" + fieldName);
            }catch(NoSuchFieldException | IllegalAccessException e){
                log.warning("Error on DI by fields");
            }
        });
    }
}

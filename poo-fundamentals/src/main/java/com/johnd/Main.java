package com.johnd;

import com.johnd.factories.*;
import com.johnd.models.*;
import com.johnd.services.GauntleServiceImpl;

import java.util.Map;


public class Main {
    public static void main(String[] args) {

       System.setProperty("scope", "singleton");

       var realityFactory = new RealityStoneFactory();
       var timeFactory = new TimeStoneFactory();
       var soulFactory = new SoulStoneFactory();
       var powerFactory = new PowerStoneFactory();
       var spaceFactory = new SpaceStoneFactory();
       var mindFactory = new MindStoneFactory();

        RealityStone reality = (RealityStone) realityFactory.createStone();
        TimeStone time = (TimeStone) timeFactory.createStone();
        SoulStone soul = (SoulStone) soulFactory.createStone();
        PowerStone power = (PowerStone) powerFactory.createStone();
        SpaceStone space = (SpaceStone) spaceFactory.createStone();
        MindStone mind = (MindStone) mindFactory.createStone();

       //final var gauntletService = new GauntleServiceImpl();

       Map<String, Stone>instances = Map.of(
               "reality", reality,
               "soul", soul,
               "mind", mind,
               "power", power,
               "space", space,
               "time", time
               );

       //gauntletService.setStones(instances);

       final var gauntletService = new GauntleServiceImpl(  //Constructor
                reality,
                soul,
                mind,
                power,
                space,
                time
        );



        gauntletService.useGauntle("reality");

        gauntletService.useFullPower();
    }
}
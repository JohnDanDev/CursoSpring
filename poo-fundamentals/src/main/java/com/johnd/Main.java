package com.johnd;

import com.johnd.factories.MindStoneFactory;
import com.johnd.factories.PowerStoneFactory;
import com.johnd.factories.RealityStoneFactory;
import com.johnd.factories.TimeStoneFactory;


public class Main {
    public static void main(String[] args) {

       System.setProperty("scope", "property");

       final var timeStoneFactory = new TimeStoneFactory();
       var timeStone = timeStoneFactory.createStone();

       final var powerStoneFactory = new PowerStoneFactory();
       var powerStone = powerStoneFactory.createStone();

       final var realityStoneFactory = new RealityStoneFactory();
       var realityStone = realityStoneFactory.createStone();

       final var mindStoneFactory = new MindStoneFactory();
       var mindStone = mindStoneFactory.createStone();

        System.out.println(timeStone);
        System.out.println(powerStone);
        System.out.println(realityStone);
        System.out.println(mindStone);
    }
}
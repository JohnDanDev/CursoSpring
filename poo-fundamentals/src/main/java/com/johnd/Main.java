package com.johnd;

import com.johnd.configs.StoneContext;
import com.johnd.factories.*;
import com.johnd.models.*;
import com.johnd.services.GauntleService;
import com.johnd.services.GauntleServiceImpl;

import java.util.Map;


public class Main {
    public static void main(String[] args) {

       /*final var gauntletService = new GauntleServiceImpl(  //Constructor
                reality,
                soul,
                mind,
                power,
                space,
                time
        );*/

        final var gauntletService = StoneContext.setContext(
                pre -> System.out.println("Do something 1"),
                post -> System.out.println("Do something 2")
        );

        gauntletService.useGauntle("power");

        gauntletService.useFullPower();

        StoneContext.destroyContext(gauntletService);
    }
}
package com.johnd.configs;

//Inversion del control

import com.johnd.factories.*;
import com.johnd.models.*;
import com.johnd.services.GauntleService;
import com.johnd.services.GauntleServiceImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.Map;
import java.util.function.Consumer;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoneContext {

    public static GauntleService setContext(
            Consumer<Void> preConstruct,
            Consumer<Void> postConstruct
    ){
        log.info("IOC set Scope");
        System.setProperty("scope", "singleton");

        log.info("IOC executing PreConstruct");
        preConstruct.accept(null);


        log.info("IOC creating factories");
        var realityFactory = new RealityStoneFactory();
        var timeFactory = new TimeStoneFactory();
        var soulFactory = new SoulStoneFactory();
        var powerFactory = new PowerStoneFactory();
        var spaceFactory = new SpaceStoneFactory();
        var mindFactory = new MindStoneFactory();

        log.info("IOC instance Object");
        RealityStone reality = (RealityStone) realityFactory.createStone();
        TimeStone time = (TimeStone) timeFactory.createStone();
        SoulStone soul = (SoulStone) soulFactory.createStone();
        PowerStone power = (PowerStone) powerFactory.createStone();
        SpaceStone space = (SpaceStone) spaceFactory.createStone();
        MindStone mind = (MindStone) mindFactory.createStone();

        log.info("IOC loading GauntletServiceImpl in container");
        final var gauntletService = new GauntleServiceImpl();

        Map<String, Stone> instances = Map.of(
                "reality", reality,
                "soul", soul,
                "mind", mind,
                "power", power,
                "space", space,
                "time", time
        );
        log.info("IOC DI on GauntletServiceImpl ");
        gauntletService.setStones(instances);

        //@PostConstruct
        log.info("IOC executing postConstruct ");
        postConstruct.accept(null);

        return gauntletService;
    }

    public static void destroyContext(GauntleService gauntleService) {


        log.info("IOC cleaning context");
        if (gauntleService instanceof GauntleServiceImpl){
            ((GauntleServiceImpl) gauntleService).getMind().clear();
            ((GauntleServiceImpl) gauntleService).getTime().clear();
            ((GauntleServiceImpl) gauntleService).getSoul().clear();
            ((GauntleServiceImpl) gauntleService).getPower().clear();
            ((GauntleServiceImpl) gauntleService).getReality().clear();
            ((GauntleServiceImpl) gauntleService).getSpace().clear();
        }

        log.info("IOC cleaning properties");
        System.clearProperty("scope");
    }
}

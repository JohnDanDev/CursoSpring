package com.johnd.factories;

import com.johnd.models.RealityStone;
import com.johnd.models.Stone;
import com.johnd.services.prototypes.Prototypes;
import com.johnd.singletons.SpaceStoneSingleton;

public class SpaceStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone() {
        if(super.isSingleton()){
            return SpaceStoneSingleton.getInstance();
        }else{
            return Prototypes.realityPrototype.buildPrototype(new RealityStone());
        }
    }
}

package com.johnd.factories;

import com.johnd.models.RealityStone;
import com.johnd.models.Stone;
import com.johnd.prototypes.Prototypes;
import com.johnd.singletons.RealityStoneSingleton;

public class RealityStoneFactory extends ConfigurableStoneFactory{
    @Override
    public Stone createStone() {
        if(super.isSingleton()){
            return RealityStoneSingleton.getInstance();
        }else{
            return Prototypes.realityPrototype.buildPrototype(new RealityStone());
        }
    }
}

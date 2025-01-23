package com.johnd.factories;

import com.johnd.models.Stone;
import com.johnd.models.TimeStone;
import com.johnd.prototypes.Prototypes;
import com.johnd.singletons.RealityStoneSingleton;

public class TimeStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone() {
        if(super.isSingleton()){
            return RealityStoneSingleton.getInstance();
        }else{
            return Prototypes.timePrototype.buildPrototype(new TimeStone());
        }
    }
}

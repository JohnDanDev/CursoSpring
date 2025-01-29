package com.johnd.factories;

import com.johnd.models.Stone;
import com.johnd.models.TimeStone;
import com.johnd.services.prototypes.Prototypes;
import com.johnd.singletons.RealityStoneSingleton;
import com.johnd.singletons.TimeStoneSingleton;

public class TimeStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone() {
        if(super.isSingleton()){
            return TimeStoneSingleton.getInstance();
        }else{
            return Prototypes.timePrototype.buildPrototype(new TimeStone());
        }
    }
}

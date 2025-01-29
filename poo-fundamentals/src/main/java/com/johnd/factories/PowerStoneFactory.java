package com.johnd.factories;

import com.johnd.models.PowerStone;
import com.johnd.models.Stone;
import com.johnd.services.prototypes.Prototypes;
import com.johnd.singletons.PowerStoneSingleton;

public class PowerStoneFactory extends ConfigurableStoneFactory{

    @Override
    public Stone createStone() {
        if(super.isSingleton()){
            return PowerStoneSingleton.getInstance();
        }else{
            return Prototypes.powerPrototype.buildPrototype(new PowerStone());
        }
    }
}

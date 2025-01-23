package com.johnd.factories;

import com.johnd.models.SoulStone;
import com.johnd.models.Stone;
import com.johnd.prototypes.Prototypes;
import com.johnd.singletons.SoulStoneSingleton;

public class SoulStoneFactory extends ConfigurableStoneFactory{


    @Override
    public Stone createStone() {
        if(super.isSingleton()){
            return SoulStoneSingleton.getInstance();
        }else{
            return Prototypes.soulPrototype.buildPrototype(new SoulStone());
        }
    }
}

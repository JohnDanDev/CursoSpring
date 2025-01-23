package com.johnd.factories;

import com.johnd.models.MindStone;
import com.johnd.models.Stone;
import com.johnd.prototypes.Prototypes;
import com.johnd.singletons.MindStoneSingleton;

public class MindStoneFactory extends ConfigurableStoneFactory{
    @Override
    public Stone createStone() {
        if(super.isSingleton()){
            return MindStoneSingleton.getInstance();
        }else{
            return Prototypes.mindPrototype.buildPrototype(new MindStone());
        }
    }
}

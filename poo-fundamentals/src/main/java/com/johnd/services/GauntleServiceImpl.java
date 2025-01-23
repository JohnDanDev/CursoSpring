package com.johnd.services;

import com.johnd.models.RealityStone;
import com.johnd.models.Stone;
import com.johnd.singletons.MindStoneSingleton;
import lombok.extern.java.Log;

//@Service
@Log
public class GauntleServiceImpl implements GauntleService {

    private final Stone reality = MindStoneSingleton.getInstance();

    @Override
    public void useGauntle(String stoneName) {
        log.info("Use stone: "+reality);
    }
}

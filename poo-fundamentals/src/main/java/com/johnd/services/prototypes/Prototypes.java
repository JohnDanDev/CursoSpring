package com.johnd.services.prototypes;

import com.johnd.models.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Prototypes {

    public static StonePrototype<MindStone> mindPrototype =
            stone -> stone.getPrototype();

    public static StonePrototype<PowerStone> powerPrototype =
            stone -> stone.getPrototype();

    public static StonePrototype<SoulStone> soulPrototype =
            stone -> stone.getPrototype();

    public static StonePrototype<SpaceStone> spacePrototype =
            stone -> stone.getPrototype();

    public static StonePrototype<RealityStone> realityPrototype =
            stone -> stone.getPrototype();

    public static StonePrototype<TimeStone> timePrototype =
            stone -> stone.getPrototype();
}

package com.johnd.prototypes;

import com.johnd.models.Stone;

@FunctionalInterface
public interface StonePrototype <S extends Stone>{ //<S> Esta interfaz se puede convertir en cualquier objeto

    S buildPrototype(S stone);  //metodo abstracto/funcion lambda
}

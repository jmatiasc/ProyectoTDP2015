package Logic;

import java.util.*;

public class Altair extends Enemigo {

	

	public Altair(Tablero t) {
		super(t);
		
	}

	public void Altair(Tablero t,Posicion p) {
        ubicacion=p;
        velocidad=32;
        modoDios=true;
    }
  
}
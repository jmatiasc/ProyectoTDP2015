package Logic;







/**
 * Clase Bomba
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Bomba {
	protected Bomberman bomberman;
	protected int alcance;
	protected Tablero miTablero;
	protected Posicion ubicacion;

	/**
	 * Constructor de bomba
	 * @param p Posición inicial de la bomba.
	 * @param alcan Alcance de la bomba.
	 * @param tab Tablero al que pertenece la bomba.
	 * @param b Bomberman al que estara ligado la bomba.
	 */
	public  Bomba(Posicion p,  int alcan,Tablero tab,Bomberman b) {
		ubicacion=p;
		alcance=alcan;
		miTablero=tab;
		bomberman=b;
	}
	
   /**
    * Calcula las posiciones alcanzadas, luego busca todas las paredes que esten dentro
    * del alcance(x+alance,x-alcance,y+alcance,y-alcance), las agrega a una estructura y luego invoca a destruir
    * Modificar la bomba del bomberman, agregarle un NULL
    */
	public void activar(Posicion p) {
		
					
			
				
			
    }
    
	/**
	 * Aumenta la cantidad de bombas de Bomberman luego de que la bomba explota.
	 */
    public void explotar() {
    	
    	Posicion  arriba[]=new Posicion[alcance];
		Posicion abajo[]=new Posicion[alcance];
		Posicion izquierda[]=new Posicion[alcance];
		Posicion derecha[]=new Posicion[alcance];
				
		
		
		for(int i=0; i<alcance;i++){
			
			
			 arriba[i]=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-(i));
			 abajo[i]=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+(i));
			 izquierda[i]=new Posicion(ubicacion.getEjeX()-(i),ubicacion.getEjeY());
			 derecha[i]=new Posicion(ubicacion.getEjeX()+(i),ubicacion.getEjeY());
			 }
		
			int cant=alcance*4+1;
			Celda [] arreglo=new Celda[cant];
			
			arreglo[0]=miTablero.obtenerCelda(ubicacion);
			
			int a=1;
			for(int  i=0; i<arriba.length;i++){
			arreglo[a]=miTablero.obtenerCelda(arriba[i]);
			a++;
			}
			
			for(int i=0; i<abajo.length;i++){
				arreglo[a]=miTablero.obtenerCelda(abajo[i]);
				a++;
			}
			
			for(int i=0; i<derecha.length;i++){
				arreglo[a]=miTablero.obtenerCelda(derecha[i]);
				a++;
			}
			
			for(int i=0; i<izquierda.length;i++){
				arreglo[a]=miTablero.obtenerCelda(izquierda[i]);
				a++;
			}
    	
    	
    	for(int i=0; i<arreglo.length;i++){
			arreglo[i].destruir();
				
			}
    	
    	if(!bomberman.GetModoDios())
    	bomberman.aumentarCantBombas();
    }
    
    /**
     * Calcula los puntos que otorga una Celda si es alcanzada por la explosión de la bomba.
     * @param arreglo Arreglo de celdas.
     * @return Puntos otorgados por la explosión de la bomba.
     */
    private int explosion(Celda arreglo[]) {
    	int suma=0;
    	int aux=0;
    	boolean listo=false;
    	int j=0;
    	while((!listo) || (j!=arreglo.length)) {
	    	aux = suma;
	    	suma += arreglo[j].destruir();
	    	if (suma-aux!=0)
	    		listo=true;
			else
				j++;
	   	}	
	    return suma;
    }
    public int getAlcance(){
    	return alcance;
    }
}
package elementosEscenario_Composite;

import java.awt.Graphics;

public class DibujoComposicionBosque extends DibujoComposicion{
    //Permite crear un Escenario-Bosque
    //Atributos
	protected DibujoEspecificoArbol miArbol;
	protected DibujoEspecificoPiedra miPiedra;
	protected DibujoEspecifico miClon;
	protected int  posicionX;
	protected int posicionY;
	
	//Constructor
	public DibujoComposicionBosque() {
		//Crea una lista con las partes del Bosque
		agregarArbolPequeño();
		agregarArbolPeClon();
		agregarPiedras();
		//Delimita la lista
		elementosDibujo.trimToSize();
	}
    //................................................................
	//Metodos propios de la clase 
	
	//Crea objeto arbol-pequeño
    public void agregarArbolPequeño(){
        posicionX = 0;
        posicionY = 300;
        miArbol = new DibujoEspecificoArbol();
        miArbol.asignarUbicacion(posicionX, posicionY);
        miArbol.asignarImagen();
        //Agrega el objeto a la lista
        this.agregarElementoDibujo(miArbol);
    }
    
    //Crea 16 objetos arboles-pequeños(CLONES)
    public void agregarArbolPeClon(){
        for(int contador =1 ; contador<=16; contador++){
            if (contador>=1 && contador<=6){
                posicionX = 0;
                posicionY = 300;
                for(int i=1 ; i<=contador; i++){
                    posicionY = posicionY - 50;   
                }
            }else if(contador>=7 && contador<= 10){
                posicionX = 0;
                posicionY = 0;
                for(int i=7 ; i<=contador; i++){
                    posicionX = posicionX +50;
                }
            }else{
                posicionX = 200;
                posicionY = 0;
                for(int i=11; i<= contador; i++){
                    posicionY = posicionY + 50;                
                }
            }
            miClon = miArbol.copiarDibujoComponente();
            miClon.asignarUbicacion(posicionX, posicionY);
            miClon.asignarImagen();
            //Agrega el objeto a la lista
            this.agregarElementoDibujo(miClon);
        }
    }
    
    //Crea objetos piedra
    public void agregarPiedras() {
    	posicionX = 75;
    	posicionY = 75;
    	miPiedra = new DibujoEspecificoPiedra();
    	miPiedra.asignarUbicacion(posicionX, posicionY);
    	miPiedra.asignarImagen();
    	//Agrega el objeto a la lista
    	this.agregarElementoDibujo(miPiedra);
    	
    	//Crea objeto piedra(CLON)
    	miClon = miPiedra.copiarDibujoComponente();
    	miClon.asignarUbicacion(posicionX+75, posicionY);
    	miClon.asignarImagen();	
    	//Agrega el objeto a la lista
    	this.agregarElementoDibujo(miClon);
    }
    
    //................................................................
  	//Metodos heredados
	@Override
	public void dibujarComponente(Graphics g) {
		for(int i=0; i<19; i++) {
			//Dibuja cada uno de los elementos en la lista
			g.drawImage(elementosDibujo.get(i).getImgDibujo(), elementosDibujo.get(i).getPosicionX(), elementosDibujo.get(i).getPosicionY(),
					elementosDibujo.get(i).getAncho(),elementosDibujo.get(i).getAlto(),null);
		}
		
	}
   
}


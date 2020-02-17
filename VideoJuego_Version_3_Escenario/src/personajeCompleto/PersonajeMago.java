package personajeCompleto;

import ordenarConstruccionPersonaje.*;

public class PersonajeMago extends PersonajeAnimado{
	public static final int ANCHO = 50, ALTO =50;
	private static int x = 50, y = 50;
	//Constructor
	public PersonajeMago() {
	}
	
	//Permite crear copias del personaje a Profundida
	@Override
	public PersonajeAnimado clonarPer() {
		PersonajeAnimado miClonMago;
        
        //Se Determinan las partes del Mago
        Director miDirector = new Director();
        BuilderMago miBuMago = new BuilderMago();
        
        miDirector.construir(miBuMago);
        
        //Se instancia el objeto para que sea Mago
        miClonMago = miBuMago.obtenerPerAnimado();
        
        //Metodos que reciben parametros
        miClonMago.asignarPosicion(this.posicionX+(PersonajeMago.x)+10, this.posicionY);
        miClonMago.asigNumImgAnimacion(this.tecla);
        PersonajeMago.x=  PersonajeMago.x + 60;
        return  miClonMago;
	}

}

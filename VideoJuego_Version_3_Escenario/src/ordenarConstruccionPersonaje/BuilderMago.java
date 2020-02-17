package ordenarConstruccionPersonaje;

import partesPersonaje.*;
import personajeCompleto.*;

public class BuilderMago implements Builder{
	//Atributos
    private PersonajeAnimado miPerMago = new PersonajeMago();
    
    public BuilderMago() {
    	
    }
    
    
    /*
     * Se envian las correspondientes partes 
    	del personaje Mago
    */
    
    @Override
    public void construirMovPer() {
    	miPerMago.asigMovPer(new MoverMago());
        
    }

    @Override
    public void asignarGolperPer() {
    	miPerMago.asigGolPer(new GolpeMago());
    }

    @Override
    public void mostrarMuertePer() {
    	miPerMago.mosMuertePer(new MuerteMago());
        
    }
    
    //Retorna el personaje-Mago
    public PersonajeAnimado obtenerPerAnimado(){
        return miPerMago;
    }

}

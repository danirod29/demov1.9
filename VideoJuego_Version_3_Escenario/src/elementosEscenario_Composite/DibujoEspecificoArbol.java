package elementosEscenario_Composite;

import java.awt.Graphics;

/**
 *
 * @author Cristian
 */
public class DibujoEspecificoArbol extends DibujoEspecifico{
    
	//Se inicializa para arbol por defecto(Pequeño)
	public DibujoEspecificoArbol(){
        //Se inicializan los tamaños de la imagen 
        this.alto = 50;
        this.ancho = 50;
        this.nombreImg = "arbolPequegno";
    }
	
	public DibujoEspecificoArbol(String nombreImg, int ancho, int alto){
    	super(nombreImg, ancho, alto);   
    }

    //Crea diferentes copias de arboles
    @Override
    public DibujoEspecifico copiarDibujoComponente() {
        DibujoEspecifico miDiEs = new DibujoEspecificoArbol();
        miDiEs.asignarUbicacion(this.posicionX, this.posicionY);
        return  miDiEs;
        
    }

	
	
    
}

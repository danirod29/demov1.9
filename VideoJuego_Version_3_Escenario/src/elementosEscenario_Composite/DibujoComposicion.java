package elementosEscenario_Composite;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class DibujoComposicion implements DibujoComponente{
    //Atributos
    protected ArrayList<DibujoEspecifico> elementosDibujo = new ArrayList<>();

    //Constructor
    public DibujoComposicion() {
    	
    }
  
    //..........................................
    //Metodos propios de la clase
    
    public ArrayList<DibujoEspecifico> getElementosDibujo() {
		return elementosDibujo;
	} 
    
    //............................................
    //Metodos heredados
    
    //Permite agregar un elemento a la lista
    @Override
	public void agregarElementoDibujo(DibujoComponente dc) {
		elementosDibujo.add((DibujoEspecifico)dc);
	}
    
    @Override
	public abstract void dibujarComponente(Graphics g);
    
    @Override
    public DibujoComponente copiarDibujoComponente() {
        /*DibujoComponente miDiCom = new DibujoComposicion();
        miDiCom.agregarElementoDibujo(this);*/
        return null;
    }
	
	

    

   
    
}

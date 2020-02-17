package elementosEscenario_Composite;

import java.awt.Graphics;

public class DibujoEspecificoPiedra extends DibujoEspecifico{
	
	//Constructores
	public DibujoEspecificoPiedra(){
        //Se inicializan los tamaños de la imagen 
        this.alto = 20;
        this.ancho = 20;
        this.nombreImg = "piedraPequegna";
    }
    public DibujoEspecificoPiedra(String nombreImg, int ancho, int alto){
        //Se inicializan los tamaños de la imagen 
        super(nombreImg,ancho,alto);
    }

    //Crea diferentes copias de piedras
    @Override
    public DibujoEspecifico copiarDibujoComponente() {
        DibujoEspecifico miDiEs = new DibujoEspecificoPiedra();
        miDiEs.asignarUbicacion(this.posicionX, this.posicionY);
        return  miDiEs;   
    }

}

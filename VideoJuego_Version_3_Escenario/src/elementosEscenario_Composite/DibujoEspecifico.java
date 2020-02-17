package elementosEscenario_Composite;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Cristian
 */
public abstract class DibujoEspecifico implements DibujoComponente{
    //Atributos
     protected int posicionX;
     protected int posicionY;
     protected int ancho;
     protected int alto;
     protected File ubicacion;
     protected Image imgDibujo;
     protected String nombreImg;
     protected DibujoEspecifico miDibujoCopia;
    
     //Sobrecarga de constructores
     public DibujoEspecifico() {	
     }
     
     public DibujoEspecifico(String nombreImg, int ancho, int alto){
    	this.nombreImg = nombreImg;
    	this.ancho = ancho;
    	this.alto = alto;   
    }
    
    //Permite asignar el tamaño de la img
    public void asignarUbicacion(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    public void asignarImagen(){
        //Asigna la ruta de la imagen
        ubicacion = new File("src/elementosEscenarioImagen/"+nombreImg+".png");
        //Crea la imagen con las especificaciones necesarias
        try {
            imgDibujo = ImageIO.read(ubicacion);
        } catch (IOException ex) {
            System.out.println(nombreImg+" NO ENCONTRADA");
        }
    }  
    
    //.....................................................
    //Metodos heredados
    @Override
	public void dibujarComponente(Graphics g) {
		g.drawImage(imgDibujo, posicionX, posicionY, ancho, alto, null);
	}
    
    
    //.....................................................
    //Metodos heredados
    
    @Override
    public  abstract DibujoEspecifico copiarDibujoComponente();

    @Override
    public void agregarElementoDibujo(DibujoComponente dc) {
    }
    
    //.....................................................
    //Metodos getter
    
	public int getPosicionX() {
		return posicionX;
	}
	
	public int getPosicionY() {
		return posicionY;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}


	public Image getImgDibujo() {
		return imgDibujo;
	}
    
  
}

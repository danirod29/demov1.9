package partesPersonaje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class MuertePersonaje{
	//Atributos 
	protected String nombreImg;
	protected File ubicacion;
	protected Image imgMuerte;
	//Almacenara los valores numericos de las imagenes
	protected int numImgMover = 1;
	protected int posicionX, posicionY;
	protected int acumulador = 0;
			
	//Constructor
	public MuertePersonaje() {	
	}
	
	//Inicializa la posicion de la img
	public void posicionActual(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
		
	//Inicializa la img del personaje
	public Image getImagenMov() {
			ubicacion = new File("src/partesPersonajeImagenes/"+nombreImg+numImgMover+".png");
				
			try {
				imgMuerte = ImageIO.read(ubicacion);
			} catch (IOException e) {
				System.out.println("No encontrada "+nombreImg);
			}
		return imgMuerte;
	} 
	
				
	//Metodo abstracto posición-muerte del personaje
	public abstract void aniMuertePer();
	public abstract void dibujarMuerte(Graphics g);
	//Metodos getter
	public int getPosicionX() {
		return posicionX;
	}
	
	public int getPosicionY() {
		return posicionY;
	}
}

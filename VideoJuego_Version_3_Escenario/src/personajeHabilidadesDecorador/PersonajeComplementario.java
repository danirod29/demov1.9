package personajeHabilidadesDecorador;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import personajeCompleto.PersonajeAnimado;

public abstract class PersonajeComplementario extends PersonajeAnimado{
	//Atributos
	protected PersonajeAnimado personajeAnimado;
	protected Image imgPersoHab;
	protected File ubicacion; 
	protected String nombreImg;
	protected int numImg =1;
	protected boolean estado = true;
	protected int acumulador =0;
	
	//Constructor
	public PersonajeComplementario(PersonajeAnimado personajeAnimado) {
		this.personajeAnimado = personajeAnimado;
	}
	
	//Permite asignar la imagen a un personaje
	public Image asignarImgHabilidad() {
			ubicacion = new File("src/partesPersonajeImagenes/"+nombreImg+numImg+".png");
			try {
				imgPersoHab = ImageIO.read(ubicacion);
			} catch (IOException e) {
				System.out.println("Fuego No encontrada extra =( "+nombreImg);
			}
		return imgPersoHab;
	}
	//.......................................................
	//Metodos abstractos
	
	public abstract void realizarHabilidad(Graphics g);
	
	@Override
	public abstract PersonajeAnimado clonarPer();

}

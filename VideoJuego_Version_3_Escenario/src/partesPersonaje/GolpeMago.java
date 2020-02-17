package partesPersonaje;

import java.awt.Graphics;

import personajeCompleto.PersonajeMago;

public class GolpeMago extends GolpePersonaje{
	
	//Constructor
	public GolpeMago() {
		this.nombreImg = "magoGolpe";
	}

	//.............................................
	//Metodos heredados
	
	@Override
	public void golpeConArmaIz() {		
		if(acumulador == 0) {
			numImgMover = 1;
			acumulador ++;
		}else {
			numImgMover = 2;
			acumulador = 0;
		}		
	}

	@Override
	public void golpeConArmaDe() {
		if(acumulador == 0) {
			numImgMover = 3;
			acumulador ++;
		}else {
			numImgMover = 4;
			acumulador = 0;
		}		
	}

	@Override
	public void golpeConArmaEspalda() {
		if(acumulador == 0) {
			numImgMover = 5;
			acumulador ++;
		}else {
			numImgMover = 6;
			acumulador = 0;
		}	
		
	}

	@Override
	public void golpeConArmaFrontal() {
		if(acumulador == 0) {
			numImgMover = 7;
			acumulador ++;
		}else {
			numImgMover = 8;
			acumulador = 0;
		}	
	}
	
	@Override
	public void dibujarGolpe(Graphics g) {
		g.drawImage(this.getImagenMov(), posicionX+250, posicionY+50, 
				PersonajeMago.ANCHO, PersonajeMago.ALTO, null);
	}

	

}

package partesPersonaje;

import java.awt.Graphics;

import personajeCompleto.PersonajeMago;

public class MuerteMago extends MuertePersonaje{
	public MuerteMago() {
		this.nombreImg = "magoMuerte";
	}

	@Override
	public void aniMuertePer() {
		if(acumulador == 0) {
			numImgMover = 1;
			acumulador ++;
		}else {
			numImgMover = 2;
			acumulador = 0;
		}		
	}

	@Override
	public void dibujarMuerte(Graphics g) {
		aniMuertePer();
		g.drawImage(this.getImagenMov(), posicionX+250, posicionY+50, 
				PersonajeMago.ANCHO, PersonajeMago.ALTO, null);
	}

}

package partesPersonaje;

import java.awt.Graphics;
import java.awt.Graphics2D;

import personajeCompleto.PersonajeMago;

public class MoverMago extends MoverPersonaje {
	//Constructo 
	public MoverMago() {
		this.nombreImg = "magoMover";
	}
	
	//.............................................
	//Metodos heredados
	
	@Override
	public void moverDerecha() {
		if(acumulador == 0) {
			numImgMover = 1;
			acumulador ++;
		}else {
			numImgMover = 2;
			acumulador = 0;
		}
		posicionX ++;
	}

	@Override
	public void moverIzquierda() {
		if(acumulador == 0) {
			numImgMover = 3;
			acumulador ++;
		}else {
			numImgMover =4;
			acumulador =0;
		}
		posicionX --;
	}

	@Override
	public void moverArriba() {
		if(acumulador == 0) {
			numImgMover = 5;
			acumulador ++;
		}else {
			numImgMover = 6;
			acumulador = 0;
		}
		posicionY --;
	}

	@Override
	public void moverAbajo() {
		if(acumulador == 0) {
			numImgMover = 7;
			acumulador ++;
		}else {
			numImgMover = 8;
			acumulador =0;
		}
		posicionY++;
	}
	
	@Override
	public void dibujarMovimiento(Graphics g) {
		g.drawImage(this.getImagenMov(), posicionX+250, posicionY+50, 
				PersonajeMago.ANCHO, PersonajeMago.ALTO, null);
	}
}

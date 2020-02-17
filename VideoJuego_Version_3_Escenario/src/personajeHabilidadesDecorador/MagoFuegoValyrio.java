package personajeHabilidadesDecorador;

import java.awt.Graphics;
import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeMago;

public class MagoFuegoValyrio extends PersonajeComplementario{

	//Constructor
	public MagoFuegoValyrio(PersonajeAnimado personajeAnimado) {
		super(personajeAnimado);
		this.nombreImg = "magoFuegoVal";
	}
	
	
	//Metodos heredados
	@Override
	public void realizarHabilidad(Graphics g) {
			g.drawImage(asignarImgHabilidad(), posicionX+250, posicionY+50, PersonajeMago.ANCHO+10,PersonajeMago.ALTO, null);
			numImg ++;
			acumulador ++;
			if(numImg == 6) {
				numImg = 1;
			}
		}

	@Override
	public PersonajeAnimado clonarPer() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package ordenarConstruccionPersonaje;

import ordenarConstruccionPersonaje.*;;

public class Director {
	//Orden en la construccion del personaje
	 public void construir(Builder miBuilder){
	        miBuilder.construirMovPer();
	        miBuilder.asignarGolperPer();
	        miBuilder.mostrarMuertePer();
	    }

}

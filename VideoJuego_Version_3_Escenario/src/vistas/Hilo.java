package vistas;

public class Hilo extends Thread{
	//Panel del juevo(Tablero)
	private PanelBosque tableroJuego;
	private boolean estado = true;
	
	public Hilo(PanelBosque tableroJuego) {
		this.tableroJuego = tableroJuego;
	}
	//Actualiza constantemente la pantalla
	public void run() {
		try {
			while(estado) {
				tableroJuego.repaint();
				Thread.sleep(250);
				tableroJuego.setFocusable(true);
			}
		} catch (Exception e) {
			System.out.println("El hilo no puede iniciar");
			
		}
	}

}

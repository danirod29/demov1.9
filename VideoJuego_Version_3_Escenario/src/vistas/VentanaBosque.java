package vistas;



import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaBosque extends JFrame{
	private Hilo hiloBosque;
	private JPanel jpBotones = new JPanel();
	private PanelBosque jpBosque;
	
	public VentanaBosque() {
		//Disposicion de la ventana
		this.setSize(600, 390);
		this.setTitle("Bosque-Pequeño");
		jpBosque = new PanelBosque();
		add(jpBosque);		
		jpBosque.setFocusable(true);
		//Se inicializa el hilo
		hiloBosque = new Hilo(jpBosque);
		//El hilo inicia (Actualiza el estado de la pantalla)
		hiloBosque.start();
	}
}


package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import elementosEscenario_Composite.DibujoComposicionBosque;
import elementosEscenario_Composite.DibujoEspecifico;
import ordenarConstruccionPersonaje.BuilderMago;
import ordenarConstruccionPersonaje.Director;
import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeMago;
import personajeHabilidadesDecorador.MagoFuegoValyrio;

class PanelBosque extends JPanel implements KeyListener, ActionListener{
	//Atributos
	//Para construir el escenario
	private DibujoComposicionBosque miBosquePequegno;
	private DibujoEspecifico elementoBosque;
	private PersonajeAnimado personajeAnimado;
	//Para construir Mago
	private BuilderMago ordenMago = new BuilderMago();
	private Director directorMago = new Director();
	private PersonajeAnimado miPersonaje = null;
	private int casosPersonaje=6;
	//Boton para clonar y recubrir personajes
	JButton jbClonar = new JButton("Clonar_Personaje");
	JButton jbDecorador = new JButton("Fuego_Valyrio");
	
	private PersonajeAnimado clon;
	private ArrayList<PersonajeAnimado> clonesPersonajes = new ArrayList<>(); 
	private ArrayList<PersonajeAnimado> clonesPersonajesRecubrir = new ArrayList<>(); 
		
	private int x,y;
	boolean estadoo = false;
	
	//Constructor
	public PanelBosque() {
		//disposicion de la ventana
		this.setLayout(new FlowLayout());
		
		miBosquePequegno = new DibujoComposicionBosque();
		setBackground(Color.WHITE);
		
		//Orden de como se construiran las partes del personaje-animado 
		directorMago.construir(ordenMago);
		
		//Retorna el personaje-animado con sus respectivas partes
		miPersonaje = ordenMago.obtenerPerAnimado();
		
		//La ventana esta a la escucha para un evento de teclado
		this.addKeyListener(this);	
		
		//Botones a la escucha
		jbClonar.addActionListener(this);
		jbDecorador.addActionListener(this);
		
		add(jbClonar);
		add(jbDecorador);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		//Dibuja el escenario
		dibujarEscenario(g);
		//Dibuja el personaje
		if(casosPersonaje == 6) {
			miPersonaje.moverPersonaje(g);
			for(int i=0; i<clonesPersonajes.size(); i++) {
				clonesPersonajes.get(i).moverPersonaje(g);
			}
		}else if(casosPersonaje == 1) {
			miPersonaje.atacarPersonaje(g);
			for(int i=0; i<clonesPersonajes.size(); i++) {
				(clonesPersonajes.get(i)).atacarPersonaje(g);
			}
		}else if(casosPersonaje == 2) {
			miPersonaje.morirPersonaje(g);
			for(int i=0; i<clonesPersonajes.size(); i++) {
				clonesPersonajes.get(i).morirPersonaje(g);
			}
		}else if(casosPersonaje == 3) {
			((MagoFuegoValyrio)miPersonaje).realizarHabilidad(g);
			for(int i=0; i<clonesPersonajesRecubrir.size(); i++) {
				((MagoFuegoValyrio)clonesPersonajesRecubrir.get(i)).realizarHabilidad(g);
			}
		}
		
	}
	public void dibujarEscenario(Graphics g) {
		miBosquePequegno.dibujarComponente(g);
	}
	
	
	//............................................
	//Acciones de los personajes(Eventos de teclado)
	@Override
	public void keyTyped(KeyEvent e) {
		//Retorna el personaje-animado con sus respectivas partes
		miPersonaje = ordenMago.obtenerPerAnimado();
		//Inicializa las acciones del personaje
		miPersonaje.asigNumImgAnimacion(e.getKeyChar()+"");
		
		//Inicializa las acciones para los clones
		for(int i = 0; i<clonesPersonajes.size(); i++) {
			(clonesPersonajes).get(i).asigNumImgAnimacion(e.getKeyChar()+"");
		}
		
		//Para el movimiento
		if(e.getKeyChar() == '4' || e.getKeyChar() == '6'|| 
				e.getKeyChar() == '8'|| e.getKeyChar() == '2') {
			//Asigna el caracter para la imagen
			casosPersonaje = 6;
		}
		//Para el ataque
		if(e.getKeyChar() == 'a'|| e.getKeyChar() == 's'||
					e.getKeyChar() == 'z'|| e.getKeyChar() == 'w'){
			//Asigna el caracter para la imagen
			casosPersonaje = 1;
		}
		//Para la muerte del personaje
		if(e.getKeyChar() == 'm') {	
			//Asigna el caracter para la imagen
			casosPersonaje = 2;
		}
		
		
		repaint();
	}
	//.............................................
	
		@Override
		public void keyPressed(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}
		
	//............................................
	//Acciones de los personajes(Eventos de Mouse)
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object boton = e.getSource();
			
			//Para ClonarPersonaje(Se agrega a la lista)
			if(boton == jbClonar ) {
				clon = miPersonaje.clonarPer();
				clonesPersonajes.add(clon);
				clonesPersonajesRecubrir.add(clon);
			}else if(boton == jbDecorador) {
			//Para recubridor(Poder del personaje)	
		
				//Saber la posición del personaje actual
				x = miPersonaje.getPosicionX();
				y = miPersonaje.getPosicionY();
				//Se recubre el personaje
				miPersonaje = new MagoFuegoValyrio(miPersonaje);
				miPersonaje.setPosicionX(x);
				miPersonaje.setPosicionY(y);	
				for(int i=0; i<clonesPersonajes.size(); i++) {
					//Saber la posición de los clones
					x = clonesPersonajes.get(i).getPosicionX();
					y = clonesPersonajes.get(i).getPosicionY();
					//Se recubren todos los clones
					clon = clonesPersonajesRecubrir.get(i);
					clon = new MagoFuegoValyrio(clonesPersonajesRecubrir.get(i));
					clon.setPosicionX(x);
					clon.setPosicionY(y);
					clonesPersonajesRecubrir.set(i,(PersonajeAnimado)clon);
				}
				casosPersonaje = 3;
			}
			this.repaint();
			this.requestFocus();
	}
}

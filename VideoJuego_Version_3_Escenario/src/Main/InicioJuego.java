package Main;

import vistas.VentanaBosque;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import elementosEscenario_Composite.DibujoEspecificoArbol;

import javax.swing.JComponent;


/**
 *
 * @author Cristian
 */
public class InicioJuego {
    public static void main(String[] args) {
        VentanaBosque jfInicio = new VentanaBosque();
        jfInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfInicio.setVisible(true);
    }         
}
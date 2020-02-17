package elementosEscenario_Composite;

import java.awt.Graphics;

public interface DibujoComponente {
    //Permite crear nuevos elemenentos para (DibujoComposicion)
    public void agregarElementoDibujo(DibujoComponente dc);
    //Permite crear clones
    public DibujoComponente copiarDibujoComponente();
    //Permite dibujar al objeto
    public void dibujarComponente(Graphics g);
}

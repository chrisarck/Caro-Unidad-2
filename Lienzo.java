/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author andra
 */
public class Lienzo extends JPanel {
    private double x, y, lado;
    private int filas;
    
    
    public Lienzo(){
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(500,500));
        
    }
    
    public Lienzo(double x, double y, double lado, int filas){
        this.x = x;
        this.y = y;
        this.lado = lado;
        this.filas = filas;
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(500,500));
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        //ROMBO
//        Tablero t = new Tablero(x,y,lado,filas);
//        t.dibujar(g2);

        //ANILLO
        Circulo e2 = new Circulo(x, y, lado, filas);
        e2.dibujar(g2);
//          Escalera esc = new Escalera(x, y, lado, filas);
//          esc.mapaCuadrado(g2);
//          Piramide pir = new Piramide(x, y, lado, filas);
//          pir.dibujar(g2);
    }
    
}

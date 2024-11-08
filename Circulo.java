/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author andra
 */
public class Circulo {
    
    private double x, y, radio;
    private int cuantos;
    public Circulo(){
        
    }
    
    public Circulo(double x, double y, double radio, int cuantos){
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.cuantos = cuantos;
    }
    
    public void dibujar(Graphics2D g){
        
        for (int j=0; j<cuantos; j++){
        Ellipse2D e = new Ellipse2D.Double(x-(radio/2)*j-radio/2, y-(radio/2)*j-radio/2, radio*(j+1), radio*(j+1));
        g.draw(e);
            
        }
    }
}

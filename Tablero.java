/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author andra
 */
public class Tablero {
    
    private double x, y, lado;
    private int filas;
    
    public Tablero(){
        
    }
    
    public Tablero(double x, double y, double lado, int filas){
        this.x = x;
        this.y = y;
        this.lado = lado;
        this.filas = filas;
        
    }
    
    public void dibujar(Graphics2D g){
        
        for (int j=0; j<filas; j++){
            
            for (int i=0; i<=j;i++){
        Rectangle2D r = new Rectangle2D.Double(x+(filas-1)*(lado)+i*lado, y+j*lado, lado, lado);
        g.draw(r);
                
            }
            
    }
        
        for (int j=0; j<filas; j++){
            
            for (int i=0; i<=j;i++){
        Rectangle2D r = new Rectangle2D.Double(x+(filas-1)*(lado)-i*lado, y+j*lado, lado, lado);
        g.draw(r);
                
            }
            
    }
        
        for(int j=filas, k=0; j>0;j--, k++){
            for(int i=0; i<j;i++){
                Rectangle2D r = new Rectangle2D.Double(x+(filas-1)*(lado)+i*lado, y+(filas-1)*lado+k*lado, lado, lado);
                g.draw(r);
            }
        }
        
        for(int j=filas, k=0; j>0;j--, k++){
            for(int i=0; i<j;i++){
                Rectangle2D r = new Rectangle2D.Double(x+(filas-1)*(lado)-i*lado, y+(filas-1)*lado+k*lado, lado, lado);
                g.draw(r);
            }
        }
        
    }
    
}

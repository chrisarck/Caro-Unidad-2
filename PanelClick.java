/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author andra
 */
public class PanelClick extends JPanel implements MouseListener{
    private String cadena;
    private double x,y,xOriginal,yOriginal,xOriginal1,yOriginal1,xOriginal2,yOriginal2,ladoX,ladoY,lado3,xNuevo,yNuevo,xMasNuevo,yMasNuevo;
    private int c;
    private ArrayList<Rectangle2D> cuadrados;
    public PanelClick(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.lightGray);
        this.addMouseListener(this);
        cadena = "";
        xOriginal = 200;
        yOriginal = 200;
        ladoX=100;
        ladoY=100;
        xOriginal1 = 280;
        yOriginal1 = 180;
        lado3=40;
        xOriginal2 = 280;
        yOriginal2 = 280;
        c=0;
        cuadrados = new ArrayList<>();
     
    }
    
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString(cadena,50,50);
        cuadrados.add(new Rectangle2D.Double(xOriginal,yOriginal,ladoX,ladoY));
        cuadrados.add(new Rectangle2D.Double(xOriginal1,yOriginal1,lado3,lado3));
        cuadrados.add(new Rectangle2D.Double(xOriginal2,yOriginal2,lado3,lado3));
        //cuadrados.clear();
        //elimina la lista de arraylist
        Rectangle2D r = cuadrados.get(0);
        Rectangle2D r1 = cuadrados.get(1);
        Rectangle2D r2 = cuadrados.get(2);
        

        g2.draw(r);
        g2.fill(r1);
        g2.fill(r2);
        
        if(r1.contains(xNuevo, yNuevo)==false&&c==2){
            if (xNuevo > xOriginal){
                //dibuja el cuadro superior derecho
                r = new Rectangle2D.Double(0,0,0,0);
                g2.draw(r);
                c=0;
            } else {
                //dibuja el cuadro superior izquierdo
                r = new Rectangle2D.Double(0,0,0,0);
                g2.draw(r);
                c=0;
            }
        }else if(r2.contains(xNuevo,yNuevo)==false&&c==2){
            if (xNuevo > xOriginal){
                //dibuja el cuadro inferior derecho
                r = new Rectangle2D.Double(xOriginal,yOriginal,xNuevo-xOriginal,xNuevo-xOriginal);
                g2.draw(r);
                c=0;
            } else {
                //dibuja el cuadro inferior izquierdo
                r = new Rectangle2D.Double(0,0,0,0);
                g2.draw(r);
            }
        } else {
            g2.draw(r);
            g2.fill(r1);
            g2.fill(r2);
        }
        


        
        if(r1.contains(xNuevo,yNuevo)&&c==2){
            if (xMasNuevo > xOriginal){
                //dibuja el cuadro superior derecho
                r = new Rectangle2D.Double(xOriginal,yMasNuevo,xMasNuevo-xOriginal,-yMasNuevo+yOriginal+ladoY);
                g2.draw(r);
                r1 = new Rectangle2D.Double(xMasNuevo-lado3/2,yMasNuevo-lado3/2,lado3,lado3); //xMasNuevo-lado1/2,yOriginal-lado1/2+lado,lado1,lado1
                r2 = new Rectangle2D.Double(xMasNuevo-lado3/2,yOriginal-lado3/2+ladoY,lado3,lado3);
                g2.fill(r1);
                g2.fill(r2);
                c=0;

                cuadrados.clear();

                xOriginal1 = xMasNuevo-lado3/2;
                yOriginal1 =yMasNuevo-lado3/2;
                ladoX = xMasNuevo-xOriginal;
                ladoY = -yMasNuevo+yOriginal+ladoY;
                yOriginal=yMasNuevo;
                xOriginal2 = xMasNuevo-lado3/2;
                yOriginal2 =yOriginal-lado3/2+ladoY;
            } else {
                //dibuja el cuadro superior izquierdo
                r = new Rectangle2D.Double(xMasNuevo,yMasNuevo,-xMasNuevo+xOriginal,-yMasNuevo+yOriginal+ladoY);
                g2.draw(r);
                r1 = new Rectangle2D.Double(xMasNuevo-lado3/2,yMasNuevo-lado3/2,lado3,lado3);//xMasNuevo-lado2/2,yMasNuevo-lado2/2,lado2,lado2
                r2 = new Rectangle2D.Double(xMasNuevo-lado3/2,yOriginal-lado3/2+ladoY,lado3,lado3);
                g2.fill(r1);
                g2.fill(r2);
                c=0;
                cuadrados.clear();
                
                //HAY UN BUG CUANDO CAMBIAN HACIA LA IZQUIERDA
                ladoX = -xMasNuevo+xOriginal;
                xOriginal=xMasNuevo;
                ladoY=-yMasNuevo+yOriginal+ladoY;
                yOriginal = yMasNuevo;
                xOriginal1=xMasNuevo-lado3/2;
                yOriginal1=yMasNuevo-lado3/2;
                xOriginal2=xMasNuevo-lado3/2;
                yOriginal2=yOriginal-lado3/2+ladoY;
                
            }
        } else if(r2.contains(xNuevo,yNuevo)&&c==2){
            if (xMasNuevo > xOriginal){
                //dibuja el cuadro inferior derecho
                r = new Rectangle2D.Double(xOriginal,yOriginal,xMasNuevo-xOriginal,yMasNuevo-yOriginal);
                g2.draw(r);
                r1 = new Rectangle2D.Double(xMasNuevo-lado3/2,yOriginal-lado3/2,lado3,lado3);
                r2 = new Rectangle2D.Double(xMasNuevo-lado3/2,yMasNuevo-lado3/2,lado3,lado3);
                g2.fill(r1);
                g2.fill(r2);
                c=0;
                cuadrados.clear();
                xOriginal1 = xMasNuevo-lado3/2;
                xOriginal2 = xMasNuevo-lado3/2;
                yOriginal1 = yOriginal-lado3/2;
                yOriginal2 = yMasNuevo-lado3/2;
                ladoX = xMasNuevo-xOriginal;
                ladoY = yMasNuevo-yOriginal;
            } else {
                //dibuja el cuadro inferior izquierdo
                r = new Rectangle2D.Double(xMasNuevo,yOriginal,xOriginal-xMasNuevo,yMasNuevo-yOriginal);
                g2.draw(r);
                r1 = new Rectangle2D.Double(xMasNuevo-lado3/2,yOriginal-lado3/2,lado3,lado3);
                r2 = new Rectangle2D.Double(xMasNuevo-lado3/2,yMasNuevo-lado3/2,lado3,lado3);
                g2.fill(r1);
                g2.fill(r2);
                c=0;
                cuadrados.clear();
                
                ladoY = yMasNuevo-yOriginal;
                yOriginal1 = yOriginal-lado3/2;
                ladoX = xOriginal-xMasNuevo;
                xOriginal = xMasNuevo;
                
                xOriginal1=xMasNuevo-lado3/2;
                xOriginal2=xMasNuevo-lado3/2;
                yOriginal2= yMasNuevo-lado3/2;
                        
                
            }
        } else {
            //aun me falta explicar bien esto
            
            g2.draw(r);
            g2.fill(r1);
            g2.fill(r2);
        }
        
        
        double y = this.y;
        double x = this.x;
        
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //aqui el mouse se encuentra donde se hizo click y se guarda la posicion
        //posicion inicial de presionar
        cadena="Click";
        if (c==0){
        xNuevo = e.getX();
        yNuevo = e.getY();
        } else{
            xMasNuevo=e.getX();
            yMasNuevo=e.getY();
        }
        
        
        
        //ahorita vbeo si elimino el repaint o nadota
        c++;
        
//        if(c==1){
//            xMasNuevo=e.getX();
//            yMasNuevo=e.getY();
//        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //aqui el mouse se encuentra presionando el panel
        cadena="Presionar";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //aqui el mouse guarda la posicion donde se solto al haber presionado
        //posicion final de presionar
        cadena="Liberado";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //aqui el mouse se encuentra dentro del panel
        cadena="Ingresar";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //aqui el mouse se encuentra fuera del panel
        cadena="Salir";
        repaint();
    }
    
}

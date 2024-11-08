/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author andra
 */
public class MiClase extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
    private Rectangle2D rec;
    private Ellipse2D eli;
    private String cadena;
    private boolean sel, sel2, inside;
    private double dx, dy;
    
    public  MiClase(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.lightGray);
        rec = new Rectangle2D.Double(50,200,100,100);
        eli = new Ellipse2D.Double(200,200,80,80);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);//que es focusable?
        cadena="";
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(sel){
            g2.setColor(Color.red);
            g2.draw(eli);
        } else {
            g2.setColor(Color.BLACK);
            g2.draw(eli);
        }
        
        if(sel2){
            g2.setColor(Color.red);
            g2.draw(rec);
        } else {
            g2.setColor(Color.BLACK);
            g2.draw(rec);
        }
        
        if(inside) g2.fill(rec);
        
        //dibuuja texto
        //g2.drawString(cadena,50,50);
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        cadena="Clicked";
        repaint();
        //solo detecta un click rapido y ya
    }

    @Override
    public void mousePressed(MouseEvent e) {
        cadena="Pressed";
        if(eli.contains(e.getPoint())){
            sel = true;
            dx = e.getX() - eli.getX();
            dy = e.getY() - eli.getY();
        } else sel = false;
        
        if(rec.contains(e.getPoint())){
            sel2 = true;
            dx = e.getX() - rec.getX();
            dy = e.getY() - rec.getY();
        } else sel2 = false;
            
        
            
        repaint();
        //detecta si mantuviste presionado
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(rec.contains(eli.getBounds2D()))
            inside = true;
        repaint();
        //detecta la ultima posicion despues de haber mantenido presionado
        //y haber usado con dragged
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        cadena="Entered";
        repaint();
        //detecta si entraste al frame
    }

    @Override
    public void mouseExited(MouseEvent e) {
        cadena="Exited";
        repaint();
        //detecta cuando te sales del frame
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(sel) eli.setFrame(e.getX()-dx,e.getY()-dy,80,80);
        if(sel2) rec.setFrame(e.getX()-dx,e.getY()-dy,100,100);
        //que hace setFrame
        repaint();
        //mantener presionado y mover el mouse al mismo tiempo
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cadena="Moved";
        repaint();
        //detecta si hay movimiento
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

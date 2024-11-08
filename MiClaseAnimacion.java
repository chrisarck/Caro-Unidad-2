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
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author andra
 */
public class MiClaseAnimacion extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    
    private Rectangle2D rAr1,rAr2,rAr3,rAb1,rAb2,rAb3;
    private boolean selAb1,selAb2,selAb3,inside1,inside2,inside3,sieteFin,tresFin,nueveFin;
    private double dx, dy;
    private String tres,siete,nueve;
    
    public MiClaseAnimacion(){
        this.setPreferredSize(new Dimension(1000,700));
        this.setBackground(Color.lightGray);
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        rAr1 = new Rectangle2D.Double(100,100,200,200);
        rAr2 = new Rectangle2D.Double(400,100,200,200);
        rAr3 = new Rectangle2D.Double(700,100,200,200);
        rAb1 = new Rectangle2D.Double(150,500,100,100);
        rAb2 = new Rectangle2D.Double(450,500,100,100);
        rAb3 = new Rectangle2D.Double(750,500,100,100);
        tres="3";
        siete="7";
        nueve="9";
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(selAb1) g2.draw(rAb1); else g2.draw(rAb1);
        if(selAb2) g2.draw(rAb2); else g2.draw(rAb2);
        if(selAb3) g2.draw(rAb3); else g2.draw(rAb3);
        if(!inside1) {
            g2.setColor(Color.black);
            g2.draw(rAr1); 
        }
        else {
            g2.setColor(Color.pink);
            g2.fill(rAr1);
            g2.setColor(Color.black);
        }
        if(!inside2) {
            g2.setColor(Color.black);
            g2.draw(rAr2); 
        }
        else {
            g2.setColor(Color.yellow);
            g2.fill(rAr2);
            g2.setColor(Color.black);
        }
        if(!inside3) {
            g2.setColor(Color.black);
            g2.draw(rAr3); 
        }
        else {
            g2.setColor(Color.red);
            g2.fill(rAr3);
            g2.setColor(Color.black);
        }
        if(!sieteFin) g2.drawString(siete,(float)rAb1.getX()+50,(float)rAb1.getY()+50); else g2.drawString(siete,(float)rAr2.getX()+100,(float)rAr2.getY()+100);
        if(!tresFin) g2.drawString(tres,(float)rAb2.getX()+50,(float)rAb2.getY()+50); else g2.drawString(tres,(float)rAr1.getX()+100,(float)rAr1.getY()+100);
        if(!nueveFin) g2.drawString(nueve,(float)rAb3.getX()+50,(float)rAb3.getY()+50); else g2.drawString(nueve,(float)rAr3.getX()+100,(float)rAr3.getY()+100);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(rAb1.contains(e.getPoint())){
            selAb1=true;
            dx = e.getX()-rAb1.getX();
            dy = e.getY()-rAb1.getY();
        } else selAb1=false;
        if(rAb2.contains(e.getPoint())){
            selAb2=true;
            dx = e.getX()-rAb2.getX();
            dy = e.getY()-rAb2.getY();
        } else selAb2=false;
        if(rAb3.contains(e.getPoint())){
            selAb3=true;
            dx = e.getX()-rAb3.getX();
            dy = e.getY()-rAb3.getY();
        } else selAb3=false;
        repaint();
    }
    //7 3 9
    @Override
    public void mouseReleased(MouseEvent e) {
        if(rAr1.contains(rAb2.getBounds2D())) {
            inside1=true;
            rAb2 = new Rectangle2D.Double(0,0,0,0);
            tresFin=true;
        }
        if(rAr2.contains(rAb1.getBounds2D())) {
            inside2=true;
            rAb1 = new Rectangle2D.Double(0,0,0,0);
            sieteFin=true;
        }
        if(rAr3.contains(rAb3.getBounds2D())) {
            inside3=true;
            rAb3 = new Rectangle2D.Double(0,0,0,0);
            nueveFin=true;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(selAb1) rAb1.setFrame(e.getX()-dx,e.getY()-dy,100,100);
        if(selAb2) rAb2.setFrame(e.getX()-dx,e.getY()-dy,100,100);
        if(selAb3) rAb3.setFrame(e.getX()-dx,e.getY()-dy,100,100);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
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

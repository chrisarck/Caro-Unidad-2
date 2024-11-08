/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Color;
import java.awt.Dimension;
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
public class MiClaseAgrandarEliRec extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
    
    private Rectangle2D rec;
    private Ellipse2D eli;
    private boolean isEli,isRec,Finish;
    private double xOriginal, yOriginal;
    private int c;
    
    public MiClaseAgrandarEliRec(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.lightGray);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        rec = new Rectangle2D.Double(0,0,0,0);
        eli = new Ellipse2D.Double(0,0,0,0);
        c=0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(c==0){
            xOriginal = e.getX();
            yOriginal = e.getY();
            c++;
        } else {
            
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_E) isEli=true;
        if(e.getKeyCode()==KeyEvent.VK_R) isRec=true;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

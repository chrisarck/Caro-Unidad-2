/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author andra
 */
public class MoverPelota extends JPanel implements KeyListener {
    
    private Ellipse2D eli;
    private boolean ar,fin,ab,izq,der;
    private double dx, dy;
    private Timer t;
    
    public MoverPelota(){
        this.setPreferredSize(new Dimension(500,700));
        this.setBackground(Color.lightGray);
        this.addKeyListener(this);
        this.setFocusable(true);
        eli = new Ellipse2D.Double(350,350,50,50);
        t = new Timer(1, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(ar){
                    eli.setFrame(eli.getX(),eli.getY()-5,eli.getWidth(),eli.getHeight());
                    if(eli.getY()==0){
                        ar=false;
                        ab=true;
                    }
                }
                if(ab){
                    eli.setFrame(eli.getX(),eli.getY()+5,eli.getWidth(),eli.getHeight());
                    if((eli.getY()+eli.getHeight())==getHeight()){
                        ab=false;
                        ar=true;
                    }
                        System.out.println(getHeight());
                }
                if(izq){
                    eli.setFrame(eli.getX()-5,eli.getY(),eli.getWidth(),eli.getHeight());
                    if(eli.getX()==0){
                        izq=false;
                        der=true;
                    }
                }
                if(der){
                    eli.setFrame(eli.getX()+5,eli.getY(),eli.getWidth(),eli.getHeight());
                }
                if(fin){
                    eli.setFrame(eli.getX(),eli.getY(),eli.getWidth(),eli.getHeight());
                    
                }
                
                repaint();
            }
            
        });
        t.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(eli);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            ar=true;
            ab=false;
            izq=false;
            der=false;
            fin=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            ar=false;
            ab=true;
            izq=false;
            fin=false;
            der=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            ar=false;
            ab=false;
            izq=false;
            fin=false;
            der=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            ar=false;
            ab=false;
            izq=true;
            fin=false;
            der=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            ar=false;
            ab=false;
            izq=false;
            fin=true;
            der=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

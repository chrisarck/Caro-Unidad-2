/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

/**
 *
 * @author andra
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

    public class Animacion extends JPanel implements KeyListener{
    private Timer t;
    private Ellipse2D eli;
    private double dx =5;
    private boolean der, izq;
    
    
    public Animacion() {
        this.addKeyListener(this);
        this.setFocusable(true);
        eli= new Ellipse2D.Double(10, 20, 50, 50);
        t= new Timer (10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*eli.setFrame(eli.getX()+dx,eli.getY(),eli.getWidth(),eli.getHeight());
                if(eli.getX()>450){
                    dx*= -1;
                }
                if(eli.getX()<=0){
                    dx*= -1;
                }*/
                
//                eli.contains(20,30);
//                new Rectangle2D.Double(10,20,20,20).contains(eli.getBounds2D());
//                eli.intersects(new Rectangle2D.Double(0,0,0,0));
                
                if(der){
                    eli.setFrame(eli.getX()+5,eli.getY(),eli.getWidth(),eli.getHeight());
                    
                    if(eli.getX()>450){
                        der=false;
                        izq=true;
                    }
                }
                
                if(izq){
                    eli.setFrame(eli.getX()-5,eli.getY(),eli.getWidth(),eli.getHeight());
                    if(eli.getX()<=0){
                        der=true;
                        izq=false;
                    }
                }
                
                
                repaint();
                
            }
        }); 
        
        t.start();
        setPreferredSize(new Dimension(500, 400));
        setBackground(new Color(250, 200, 200));
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Color c = new Color(120,80,150,150);
        g2.setColor(c);
        /*BasicStroke stroke = new BasicStroke (20);
        g2.setStroke(stroke);*/
        g2.fill(eli);
    }
    

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            der=true;
            izq=false;
            
        }
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            der=false;
            izq=true;
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

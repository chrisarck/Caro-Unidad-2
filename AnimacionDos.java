/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimacionDos extends JPanel implements KeyListener, MouseListener{
    private Timer t;
    private int dx=60, dy=360;
    private int dx1=360, dy1=360;
    private int dx2=660, dy2=360;
    private Rectangle2D rec, rec1, rec2;
    private Rectangle2D rect, rect1, rect2;
    private boolean aden, aden1, aden2;
    private boolean inside, inside1, inside2;
    private boolean dibujarRectangulo=true;
    private boolean dibujarRectangulo1=true;
    private boolean dibujarRectangulo2=true;
    private boolean der, izq, arri, aba, intro;
    public AnimacionDos(){
        this.addKeyListener(this);
        this.setFocusable(true);
        this.addMouseListener(this);
        
        //chiquillos
        rec=new Rectangle2D.Double(10, 310, 100, 100);
        rec1=new Rectangle2D.Double(310, 310, 100, 100);
        rec2=new Rectangle2D.Double(610, 310, 100, 100);
        //grandes
        rect=new Rectangle2D.Double(10, 10, 200, 200);
        rect1=new Rectangle2D.Double(310, 10, 200, 200);
        rect2=new Rectangle2D.Double(610, 10, 200, 200);
        
        
        t= new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //1
            if(aden){    
                if (der){
                    rec.setFrame(rec.getX()+5, rec.getY(),rec.getWidth(), rec.getHeight());
                    dx+=5;
                }
                if (izq){
                    rec.setFrame(rec.getX()-5, rec.getY(),rec.getWidth(), rec.getHeight());
                    dx-=5;
                }
                if (arri){
                    rec.setFrame(rec.getX(), rec.getY()-5,rec.getWidth(), rec.getHeight());
                    dy-=5;
                }
                if (aba){
                    rec.setFrame(rec.getX(), rec.getY()+5,rec.getWidth(), rec.getHeight());
                    dy+=5;
                }
                if (intro){
                    rec.setFrame(rec.getX(), rec.getY(),rec.getWidth(), rec.getHeight());
                }
            }
            repaint();
                //2
            if(aden1){    
                if (der){
                    rec1.setFrame(rec1.getX()+5, rec1.getY(),rec1.getWidth(), rec1.getHeight());
                    dx1+=5;
                }
                if (izq){
                    rec1.setFrame(rec1.getX()-5, rec1.getY(),rec1.getWidth(), rec1.getHeight());
                    dx1-=5;
                }
                if (arri){
                    rec1.setFrame(rec1.getX(), rec1.getY()-5,rec1.getWidth(), rec1.getHeight());
                    dy1-=5;
                }
                if (aba){
                    rec1.setFrame(rec1.getX(), rec1.getY()+5,rec1.getWidth(), rec1.getHeight());
                    dy1+=5;
                }
                if (intro){
                    rec1.setFrame(rec1.getX(), rec1.getY(),rec1.getWidth(), rec1.getHeight());
                }
            }    
                //3
            if(aden2){    
                if (der){
                    rec2.setFrame(rec2.getX()+5, rec2.getY(),rec2.getWidth(), rec2.getHeight());
                    dx2+=5;
                }
                if (izq){
                    rec2.setFrame(rec2.getX()-5, rec2.getY(),rec2.getWidth(), rec2.getHeight());
                    dx2-=5;
                }
                if (arri){
                    rec2.setFrame(rec2.getX(), rec2.getY()-5,rec2.getWidth(), rec2.getHeight());
                    dy2-=5;
                }
                if (aba){
                    rec2.setFrame(rec2.getX(), rec2.getY()+5, rec2.getWidth(), rec2.getHeight());
                    dy2+=5;
                }
                if (intro){
                    rec2.setFrame(rec2.getX(), rec2.getY(),rec2.getWidth(), rec2.getHeight());
                }
            }    
                repaint();
            }
        });
        t.start();
        setPreferredSize(new Dimension(500,400));
        setBackground(Color.black);
        
        
    }
    
    @Override
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.green);
        //chiquillos
            
        
        
        if (dibujarRectangulo) {
            g2.draw(rec);
            g2.drawString("7", dx, dy);
        }
        
        if (dibujarRectangulo1) {
            g2.draw(rec1);
        g2.drawString("3", dx1, dy1); 
        }
        
        if (dibujarRectangulo2) {
            g2.draw(rec2);
        g2.drawString("9", dx2, dy2);
        }
        
        if(inside){
            g2.setColor(Color.DARK_GRAY);
            g2.fill(rect);
            
        }
        if(inside1){
            g2.setColor(Color.DARK_GRAY);
            g2.fill(rect1);
        }
        if(inside2){
            g2.setColor(Color.DARK_GRAY);
            g2.fill(rect2);
        }
        
        //grandotes
        g2.setColor(Color.BLUE);
        g2.draw(rect);
        g2.draw(rect1);
        g2.draw(rect2);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            
            der=true;
            izq=false;
            arri=false;
            aba=false;
        
        }
        
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            
            der=false;
            izq=true;
            arri=false;
            aba=false;
        
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            
            der=false;
            izq=false;
            arri=true;
            aba=false;
        
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            
            der=false;
            izq=false;
            arri=false;
            aba=true;
        
        }
        
        repaint();
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            
            der=false;
            izq=false;
            arri=false;
            aba=false;
        
        }
        
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(rect.contains(rec1.getBounds2D())){
    inside=true;
        dibujarRectangulo1=false;
        }
        if(rect1.contains(rec.getBounds2D())){
    inside1=true;
        dibujarRectangulo=false;
        }
        if(rect2.contains(rec2.getBounds2D())){
    inside2=true;
        dibujarRectangulo2=false;
        }
    repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
                
        if(rec.contains(e.getPoint())){
    aden=true;
    } else{
        aden=false;
        }

    if(rec1.contains(e.getPoint())){
    aden1=true;
    } else{
        aden1=false;}

    if(rec2.contains(e.getPoint())){
    aden2=true;
    } else{
        aden2=false;}
    repaint();
    
    }

    @Override
    public void mousePressed(MouseEvent e) {    
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

}

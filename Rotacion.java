/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

/**
 *
 * @author andra
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author fide
 */
public class Rotacion extends JPanel implements KeyListener{
    private Shape r, u;
     int x = 0;
     int vel = 20;
    private AffineTransform at;
    private int grados;
    public  Rotacion(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.lightGray);
        r = new Rectangle2D.Double(240,200,20,100);
        at = new AffineTransform();
        this.addKeyListener(this);
        this.setFocusable(true);
//        at.setToScale(1.2, 1.2);//escalamiento
//         at.setToRotation(Math.toRadians(25),250,250);  //permite establoecer rotacion de ciertos grados

        Timer t = new Timer(10,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                if(x % 360 == 0) x = 1;
                at.setToRotation(Math.toRadians(x),250,250);  //permite establoecer rotacion de ciertos grados
                ++x;
                repaint();
            }
        });
//        t.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        u = at.createTransformedShape(r);
        g2.draw(u);

        g2.drawString(Integer.toString(x), 20,20);
                
    }
    
    //todas las transformaciines deben tener shape
    //cuando se escala en un grafico, todo el pixel se escala

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( x<=360) {


        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT: 
            if(x<=340)
            x += vel;
            
                break;
           case KeyEvent.VK_LEFT: 
            if(x>=-340)
            x -= vel;
                break;
           
        }
        at.setToRotation(Math.toRadians(x),250,250);
          repaint();
                        }
//        if(x%360 == 0) x=0;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

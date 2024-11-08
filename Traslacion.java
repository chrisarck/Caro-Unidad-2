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
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author fide
 */
public class Traslacion extends JPanel implements KeyListener{
    ArrayList <Ellipse2D> elis = new ArrayList<>();
    ArrayList <Ellipse2D> ejecucion = new ArrayList<>();
    AffineTransform at = new AffineTransform();
    private int y, x, xAcumulado, yAcumulado;
    Shape r = new Rectangle2D.Double(0,0,30,20);
    Shape s;
    //con shape puedes usar ellipse y redtcangle
    //transformaciones sirven para modificar atributos
    //tamanio, rotacion, amplio
    //traslacion, escalamiento y rotacion
    //que putas es un delay?
    //delay, timer, transformaciones
    
    public Traslacion(){
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(500,500));
        at.setToTranslation(50,200);
        s = at.createTransformedShape(r);
        addKeyListener(this);
        setFocusable(true);
        for(int i = 0; i < 3; ++i){
            Random rand = new Random();
            double ancho = rand.nextDouble(450);
            int alto = rand.nextInt(450);
            elis.add(new Ellipse2D.Double(ancho,alto,30,30));
        }
        Timer timer = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                xAcumulado += x;
                yAcumulado += y;
                 at.setToTranslation( xAcumulado,yAcumulado);
                 if(xAcumulado <= 0 || xAcumulado + 30 >= getWidth()) x = -x;
                 if(yAcumulado <= 0 || yAcumulado + 20>= getHeight()) y = -y;
                 s = at.createTransformedShape(r);
                 for(Ellipse2D el : elis){
                     if(s.intersects(el.getX(), el.getY(), el.getWidth(), el.getHeight())){
                         ejecucion.add(el);    
                         break;
                      }
                 }
                 for(Ellipse2D el : ejecucion) {
                     elis.remove(el);
                 }
                     
                 repaint();
            }
        });
        timer.start();
    }
    
      @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        g2.fill(s);
        for(Ellipse2D e: elis) g2.draw(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        x = 0;
        y = 0;
            if(e.getKeyCode() == KeyEvent.VK_UP){
               y = -5;
           }
           if(e.getKeyCode() == KeyEvent.VK_DOWN){
               y = 5;
           }
           if(e.getKeyCode() == KeyEvent.VK_LEFT){
               x = -5;
           }
           if(e.getKeyCode() == KeyEvent.VK_RIGHT){
               x = 5;
           }
           repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
}

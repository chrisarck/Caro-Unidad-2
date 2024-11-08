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
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 
 * @author fide
 */
public class TresRectangulos extends JPanel implements KeyListener, MouseMotionListener, MouseListener{
    ArrayList<Rectangle> rectSup= new ArrayList<Rectangle>();
    ArrayList<Rectangle> rectInf= new ArrayList<Rectangle>();
    ArrayList<Integer> rands = new ArrayList();
    ArrayList<Integer> randsOrd= new ArrayList();
    ArrayList<Integer> recsFill = new ArrayList();
    int recPer = -1;
    private int x = 0, y = 0;
    private int numInf,numSup;

    public TresRectangulos(JFrame frame, int numRecs){
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setVisible(true);
        numInf = numRecs;
        numSup = numRecs;
        for(int i = 0; i < numInf; ++i){
            Random rand = new Random();
            int randInt = rand.nextInt(11);
            rands.add(randInt);
        }
        randsOrd = new ArrayList<>(rands);
        Collections.sort(randsOrd);
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        Timer timer = new Timer(1, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(recPer != -1){
                    Rectangle recti = rectInf.get(recPer);
                    recti.setFrame(recti.x + x, recti.y +y,recti.width,recti.height);
                    Dimension sz = frame.getSize();
                    if(recti.x <= 0) x = 5;
                    if(recti.y <= 0) y = 5;
                    if(recti.x+recti.width > sz.width) x= -5;
                    if(recti.y +recti.height> sz.height) y = -5;
                    for(int i = 0; i < numSup; ++i){
                        Rectangle rects = rectSup.get(i);
                        boolean bound = rects.contains(recti.getBounds2D());
                        boolean orden = Objects.equals(rands.get(recPer), randsOrd.get(i));
                        if(bound && orden){
                            recsFill.add(i);
                            rectInf.remove(recPer);
                            rands.remove(recPer);
                            --numInf;
                            recPer = -1;
                            break;
                        }
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            setBackground(new Color( 127, 249, 195 ));
            Graphics2D g2 = (Graphics2D)g;

            for(int i = 0; i < numSup; ++i) {
                rectSup.add(new Rectangle(100 + i*200,100,100,100));
            }

            for(int i = 0; i < numSup; ++i) {
                Rectangle rects= rectSup.get(i);
                g2.setColor(new Color( 89, 184, 255 ));
                g2.draw(rects); 
            }

            for(int i = 0; i < numInf; ++i) {
                rectInf.add(new Rectangle(150 + i*200,300,50,50));
            }

            for(int i = 0; i < numInf; ++i) {
                g2.setColor(new Color(  72, 43, 255 ));
                Rectangle recti = rectInf.get(i);                
                g2.drawString(Integer.toString(rands.get(i)),recti.x + recti.width/2 , recti.y + recti.height/2);
                g2.draw(recti);
            }

            g2.setColor(new Color( 217, 164, 255 ));
            if(recPer != -1) g2.draw(rectInf.get(recPer));

            for(int re : recsFill) g2.fill(rectSup.get(re));
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
    }
    @Override
    public void mousePressed(MouseEvent e) {
        recPer = -1;
        for(int i = 0; i < numInf; ++i){
            Rectangle recti = rectInf.get(i);
            if(recti.contains(e.getPoint())) {
                System.out.println(rands.get(i));
                x = 0;
                y = 0;
                recPer = i;
                break;
            }
       }
       repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

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

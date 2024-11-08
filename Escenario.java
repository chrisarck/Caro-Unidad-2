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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author fide
 */
class Escenario extends JPanel implements KeyListener {
    ArrayList <Bola> balas = new ArrayList<>();
    ArrayList <Bola> balasRmvd = new ArrayList<>();
    Arma arma = new Arma(400,400,Color.lightGray);
    private boolean up, down, dispara;
    private Bola bala = new Bola(100,100);
    public Escenario(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.red);
        this.addKeyListener(this);
        setFocusable(true);
        Timer t = new Timer(5, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(up) arma.up();
                else if(down) arma.down();
                if(dispara) {
                    for(Bola bali: balas) bali.left();
                }
                for(Bola bali: balas){
                    if(bali.getX() <= 0){
                        balasRmvd.add(bali);
                    }
                }
                for(Bola bali: balasRmvd) balas.remove(bali);
                repaint();
            }
        });

        t.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        arma.draw(g2);
        for(Bola bali : balas) bali.draw(g2);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        up = false;
        down = false;
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP -> up = true;
            case KeyEvent.VK_DOWN -> down = true;
            case KeyEvent.VK_SPACE -> {
                balas.add(new Bola(arma.getX(),arma.getY()));
                dispara = true;
                System.out.println(balas.size());
            }
            case KeyEvent.VK_RIGHT -> arma.parar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}

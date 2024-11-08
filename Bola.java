/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

/**
 *
 * @author andra
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author fide
 */
public class Bola {
    private Ellipse2D eli;
    private int x, y;
    private BufferedImage img;
    
    public Bola(int x, int y){
        //la imagen se pone en el constructor y no en el paint
        this.x=x;
        this.y=y;
        eli = new Ellipse2D.Double(this.x,this.y,30,30);
        try {
            img = ImageIO.read(new File("C:\\Users\\andra\\Downloads\\solsito.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void left(){
        eli.setFrame(eli.getX()-5,eli.getY(),30,30);
    }

    public int getX() {
        return (int) eli.getX();
    }

    public int getY() {
        return y;
    }
    
    
    
    public void draw(Graphics2D g2){
        g2.setPaint(new TexturePaint(img,eli.getBounds2D()));
        g2.fill(eli);
    }
}

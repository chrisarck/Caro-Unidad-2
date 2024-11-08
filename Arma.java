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
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author fide
 */
public class Arma {
    private Rectangle2D r;
    private int x, y;
    private Color c;
    
    public Arma(int x, int y, Color color){
        this.x = x;
        this.y = y;
        c = color;
        r = new Rectangle2D.Double(this.x,this.y,100,30);
    }
    
    public void draw(Graphics2D g){
                r.setFrame(r.getX(), r.getY()+vel,100,30);

        g.draw(r);
        
    }

    public int getX() {
        return (int)r.getX();
    }

    public int getY() {
        return (int)r.getY();
    }
    
    int vel = 5;
    public void up(){
        vel = -5;
    }
    
    public void down(){
        vel = 5;
    }
    
    public void parar(){
        vel = 0;
    }

    

}

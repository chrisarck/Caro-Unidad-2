/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author andra
 */
public class FrecuenciaLienzo extends JPanel {
    
    private double x, y, lado, radio;
    private int filas, cuantos;
    
    private JButton boton;
    private JTextField caja;
    private JLabel etiqueta;
    
    private String cadena;
    
    
    public FrecuenciaLienzo(){
        cadena="";
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.GREEN);
        boton = new JButton("Aceptar");
        caja = new JTextField("Escribe aqui");
        etiqueta = new JLabel("Mensaje: ");
        this.setLayout(null);
        //x, y, ancho, alto
        boton.setBounds(200, 300, 100, 30);
        caja.setBounds(200,350,100,30);
        etiqueta.setBounds(200,400,100,30);
        caja.setText("");
        boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String texto = caja.getText();
                Rectangle2D r = new Rectangle2D.Double(100,100,40,54);
}
    }
     );
    
        
        
        this.add(boton);
        this.add(caja);
        this.add(etiqueta);   
    }
    
    public void dibujarFrecuencia(){
        
    }
    
    public FrecuenciaLienzo(double x, double y, double lado, int filas){
        this.x = x;
        this.y = y;
        this.lado = lado;
        this.filas = filas;
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.GREEN);
    }
    

    
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
//        Tablero t = new Tablero(x,y,lado,filas);
//        t.dibujar(g2);
//        Circulos e2 = new Circulos(x, y, lado, filas);
//        e2.dibujar(g2);
////          Escalera esc = new Escalera(x, y, lado, filas);
////          esc.mapaCuadrado(g2);
        double y = this.y;
        double x = this.x;
        g2.drawString(cadena, 200, 500);
    }
    
}

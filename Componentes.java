/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carosito;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author andra
 */
public class Componentes extends JPanel {
    private double x, y, lado, radio;
    private int filas, cuantos; 
    
    private JButton boton;
    private JTextField caja;
    private JLabel etiqueta, numCuantos;
    private JLabel etiquetaDos;
    
    private String cadena;
    
    public Componentes(){
        cadena="";
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.lightGray);
        boton = new JButton("Aceptar");
        caja = new JTextField("Escribe aqui");
        etiqueta = new JLabel("Mensaje: ");
        etiquetaDos = new JLabel();
        numCuantos = new JLabel("Introduce los numeros: ");
        this.setLayout(null);
        
        boton.setBounds(200,300,100,30);
        caja.setBounds(200,350,100,30);
        etiqueta.setBounds(200,400,100,30);
        etiquetaDos.setBounds(0,0,100,30);
        
        boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                etiqueta.setText(caja.getText());
//                etiquetaDos.setText(caja.getText());
                
//                String texto = caja.getText();
//                String [] numeros = texto.split(" ");
//                    etiquetaDos.setText(numeros[2]);
//                int x=0;
//                for (String numero: numeros){
//                    etiquetaDos.setText(numero);
//                    x += 50;
//                    etiquetaDos.setBounds(0,0+x,100,30);
//                }
//                etiquetaDos.setBounds(0,50,100,30);
//                    etiquetaDos.setText(numeros[1]);
                
            }
        });
        
        this.add(boton);
        this.add(caja);
        this.add(etiqueta);
        this.add(etiquetaDos);
        
        
    }
    
    public Componentes(double x, double y, double lado, int filas){
        this.x = x;
        this.y = y;
        this.lado = lado;
        this.filas = filas;
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.lightGray);
    }
}

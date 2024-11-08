/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carosito;

import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author andra
 */
public class Carosito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rotacion();
    }
    
    public static void Rotacion(){
        JFrame f = new JFrame();
        Rotacion r = new Rotacion();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(r);
        f.pack();
        f.setVisible(true);
    }
    
    public static void Traslacion() {
        JFrame f = new JFrame();
        Traslacion l = new Traslacion();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l);
        f.pack();
        f.setVisible(true);
    }
    
    public static void Escenario(){
        JFrame f = new JFrame();
        Escenario l = new Escenario();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l);
        f.pack();
        f.setVisible(true);
        
    }
    
    public static void TresRectangulos(){
        JFrame f = new JFrame();
        TresRectangulos l = new TresRectangulos(f,3);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(l);
        f.setVisible(true);
        
        
    }
    
    public static void moverPelota(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MoverPelota l = new MoverPelota();
        f.add(l);
        f.pack();
        f.setVisible(true);
        
    }
    
    public static void AnimacionMover(){
        JFrame f = new JFrame();
        AnimacionDos am = new AnimacionDos();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(am);
        f.pack();
        f.setVisible(true);
        
    }
    
    public static void Animacion(){
        JFrame f = new JFrame("Animaciooon");
        Animacion a = new Animacion();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(a);
        f.pack();
        f.setVisible(true);
    }
    
    public static void ordenarNumeros(){
        JFrame f = new JFrame("Programa ordenar numeros");
        MiClaseAnimacion an = new MiClaseAnimacion();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(an);
        
        f.pack();
        f.setVisible(true);
    }
    
    public static void agrandarEliRec(){
        JFrame f = new JFrame();
        MiClaseAgrandarEliRec er = new MiClaseAgrandarEliRec();
        f.add(er);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    public static void eventos(){
        JFrame f = new JFrame();
        MiClase ev = new MiClase();
        f.add(ev);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    public static void mouse(){
        JFrame f = new JFrame();
        PanelClick c = new PanelClick();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(c);
        f.pack();
        f.setVisible(true);
    }
    
    public static void botonLabel(){
        JFrame fra = new JFrame();
        fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fra.setSize(500,500);
        Componentes l = new Componentes();
        fra.add(l);
        fra.pack();
        fra.setVisible(true);
    }
    
    
    public static void circuloDibujar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Dame x: ");
        double x = scan.nextDouble();
        System.out.println("Dame y: ");
        double y = scan.nextDouble();
        System.out.println("Dame el radio: ");
        double radio = scan.nextDouble();
        System.out.println("Dame cuantos: ");
        int cuantos = scan.nextInt();
        
        JFrame fra = new JFrame();
        fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fra.setSize(500,500);
        Lienzo l = new Lienzo(x, y, radio, cuantos);
        fra.add(l);
        fra.pack();
        fra.setVisible(true);
    }
    
    public static void tableroDibujar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Dame x: ");
        double x = scan.nextDouble();
        System.out.println("Dame y: ");
        double y = scan.nextDouble();
        System.out.println("Dame el lado: ");
        double lado = scan.nextDouble();
        System.out.println("Dame las filas: ");
        int filas = scan.nextInt();
        
        JFrame fra = new JFrame();
        fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fra.setSize(500,500);
        Lienzo l = new Lienzo(x, y, lado, filas);
        fra.add(l);
        fra.pack();
        fra.setVisible(true);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Vista extends JPanel implements ActionListener {
    private int Estado;
    private Personaje personaje;
    private Timer timer;
    private EventosTeclado teclado;
    private Mapa mapa;
    private Mapa2 mapa2;
    private int vidas=3;
    private int puntaje = 0;
    private int base = 625;
    private boolean choca = false;
    private int altura;
    private int alturaInicial;
    private int saltoEstado;
    private int alturaMinima;
    private JButton botonstart;
    private JButton botonsalir;

    public Vista() {
        this.Estado=2;
        this.mapa2= new Mapa2();
        botonstart= new JButton();
        this.botonsalir= new JButton();
        this.timer = new Timer(10, this);
        this.personaje = new Personaje(0, 625);
        this.teclado = new EventosTeclado();
        this.mapa = new Mapa();
        this.altura = 0;
        this.saltoEstado = 0;
        addKeyListener(this.teclado);
        setFocusable(true);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.Estado==0){
            Image fondo1= Toolkit.getDefaultToolkit().getImage("parallax-mountain.png");
            g.drawImage(fondo1,0,0,1920,1080,0,0,272,160, this);
            ImageIcon start= new ImageIcon();
            start.setImage(Toolkit.getDefaultToolkit().getImage("cajainicio.png"));
            ImageIcon exit=new ImageIcon();
            exit.setImage(Toolkit.getDefaultToolkit().getImage("cajasalir.png"));
            botonsalir.setIcon(exit);
            botonstart.setIcon(start);
            botonstart.setBorder(null);
            botonsalir.setBorder(null);
            botonstart.setLayout(null);
            botonsalir.setLayout(null);
            botonstart.setBounds(new Rectangle(800,500,317,77));
            botonsalir.setBounds(new Rectangle(800,580,317,77));
            add(botonstart);
            add(botonsalir);
            botonstart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   Estado=1;


                }
            });
            botonsalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   System.exit(0);
                }
            });
        }
        else if(this.Estado==1){
        botonstart.setVisible(false);
        botonsalir.setVisible(false);
        Image corazon= Toolkit.getDefaultToolkit().getImage("heart.png");
        Image monedaestatica= Toolkit.getDefaultToolkit().getImage("Full Coins.png");
        g.drawImage(this.mapa.getFoto(), this.mapa.getX(), this.mapa.getY(), this);
          g.setFont( new Font( "Tahoma", Font.BOLD, 30) );
        g.drawString(String.valueOf(this.puntaje),927, 36);
        g.drawImage(corazon,960,0, this);
        g.drawImage(monedaestatica, 890, 10,922,42,0,0,16,16, this);
        g.drawString(String.valueOf(this.vidas),1000,36);
        for (Caja caja : this.mapa.getCajas()) {
            g.drawImage(caja.getFoto(), caja.getX() + this.mapa.getX(), caja.getY(), this);
        }
                for (int i = 0; i < this.mapa.getChuzos().length; i++) {
            g.drawImage(this.mapa.getChuzos()[i].getFoto(), this.mapa.getChuzos()[i].getX()+this.mapa.getX(),
                    this.mapa.getChuzos()[i].getY(), this.mapa.getChuzos()[i].getX()+this.mapa.getX()+60,this.mapa.getChuzos()[i].getY()+60,
                    0,0,160,160,this);
        }
        for (int i = 0; i < (this.mapa.getPiso().length/2); i++) {
            g.drawImage(this.mapa.getPiso()[i].getFoto(),this.mapa.getPiso()[i].getX()+this.mapa.getX(),this.mapa.getPiso()[i].getY(),this);
        }
         for (int i = (this.mapa.getPiso().length/2); i <this.mapa.getPiso().length; i++) {
            g.drawImage(this.mapa.getPiso()[i].getFototierra(),this.mapa.getPiso()[i].getX()+this.mapa.getX(),this.mapa.getPiso()[i].getY(),this);
        }
        for (Moneda moneda : this.mapa.getMonedas()) {
            g.drawImage(moneda.getFoto(), moneda.getX() + this.mapa.getX(), moneda.getY(), moneda.getX() + this.mapa.getX() + 32,
                    moneda.getY() + 32, (16 * moneda.getXsprite()), 0, (16 + (moneda.getXsprite() * 16)),
                    16, this);
        }
        g.drawImage(this.personaje.getImagen(), this.personaje.getX(), this.personaje.getY() - 10,
                this.personaje.getX() + 92, this.personaje.getY() + 100,
                (this.personaje.getXsprite() * 46), (this.personaje.getYsprite() * 50),
                ((this.personaje.getXsprite() * 46) + 46), ((this.personaje.getYsprite() * 50) + 50), this);
        g.drawImage(this.mapa.getBandera().getFoto(),this.mapa.getBandera().getX()+this.mapa.getX(),this.mapa.getBandera().getY()-200,
                this.mapa.getBandera().getX()+this.mapa.getX()+150,this.mapa.getBandera().getY()+180,(38*this.mapa.getBandera().getXsprite()),0,
                38+(38*this.mapa.getBandera().getXsprite()),138,this);
        }
        else if(this.Estado==2){
            for (int i = 0; i < this.mapa2.getPiso().length; i++) {
               this.mapa2.getPiso()[i].setFoto(Toolkit.getDefaultToolkit().getImage("grass_dead_128x128.png"));
            }
                        g.drawImage(this.mapa2.getFoto(), 0,0,1920,1080,
                    0,0,272,160,this);
            Image corazon= Toolkit.getDefaultToolkit().getImage("heart.png");
        Image monedaestatica= Toolkit.getDefaultToolkit().getImage("Full Coins.png");
          g.setFont( new Font( "Tahoma", Font.BOLD, 30) );
        g.drawString(String.valueOf(this.puntaje),927, 36);
        g.drawImage(corazon,960,0, this);
        g.drawImage(monedaestatica, 890, 10,922,42,0,0,16,16, this);
        g.drawString(String.valueOf(this.vidas),1000,36);
        for (Caja caja : this.mapa2.getCajas()) {
            g.drawImage(caja.getFoto(), caja.getX() + this.mapa2.getX(), caja.getY(), this);
        }
                for (int i = 0; i < this.mapa2.getChuzos().length; i++) {
            g.drawImage(this.mapa2.getChuzos()[i].getFoto(), this.mapa2.getChuzos()[i].getX()+this.mapa2.getX(),
                    this.mapa2.getChuzos()[i].getY(), this.mapa2.getChuzos()[i].getX()+this.mapa2.getX()+60,this.mapa2.getChuzos()[i].getY()+60,
                    0,0,160,160,this);
        }

            g.drawImage(this.personaje.getImagen(), this.personaje.getX(), this.personaje.getY() - 10,
                this.personaje.getX() + 92, this.personaje.getY() + 100,
                (this.personaje.getXsprite() * 46), (this.personaje.getYsprite() * 50),
                ((this.personaje.getXsprite() * 46) + 46), ((this.personaje.getYsprite() * 50) + 50), this);
                    for (int i = 0; i < (this.mapa2.getPiso().length/2); i++) {
            g.drawImage(this.mapa2.getPiso()[i].getFoto(),this.mapa2.getPiso()[i].getX()+this.mapa2.getX(),this.mapa2.getPiso()[i].getY(),this);
        }
         for (int i = (this.mapa2.getPiso().length/2); i <this.mapa2.getPiso().length; i++) {
            g.drawImage(this.mapa2.getPiso()[i].getFototierra(),this.mapa2.getPiso()[i].getX()+this.mapa2.getX(),this.mapa2.getPiso()[i].getY(),this);
        }
        for (Moneda moneda : this.mapa2.getMonedas()) {
            g.drawImage(moneda.getFoto(), moneda.getX() + this.mapa2.getX(), moneda.getY(), moneda.getX() + this.mapa2.getX() + 32,
                    moneda.getY() + 32, (16 * moneda.getXsprite()), 0, (16 + (moneda.getXsprite() * 16)),
                    16, this);
        }
        g.drawImage(this.mapa2.getBandera().getFoto(),this.mapa2.getBandera().getX()+this.mapa2.getX(),this.mapa2.getBandera().getY()-200,
                this.mapa2.getBandera().getX()+this.mapa2.getX()+150,this.mapa2.getBandera().getY()+180,(38*this.mapa2.getBandera().getXsprite()),0,
                38+(38*this.mapa2.getBandera().getXsprite()),138,this);
        }
    }
    public void camara() {
        if(this.Estado==1){
        this.mapa.setX(this.mapa.getX() - 1);
    }
        else if(this.Estado==2){
            this.mapa2.setX(this.mapa2.getX() - 1);
        }
    }

    public boolean colisionar() {
        this.choca=false;
        boolean bmoneda=false;
        if(this.Estado==1){
        this.mapa.bordes();
        this.mapa.setBordebandera(new Rectangle(this.mapa.getBandera().getX()+this.mapa.getX()-30,this.mapa.getBandera().getY(),
        150,138));
        this.personaje.setBordes(new Rectangle(this.personaje.getX()+22, this.personaje.getY(), 50, 95));
        for (Moneda moneda : this.mapa.getMonedas()) {
            moneda.setBordes(new Rectangle(moneda.getX() + this.mapa.getX(), moneda.getY(), 32, 32));
        }
        for (int i = 0; i < this.mapa.getBordescajas().length; i++) {
            if (this.mapa.getBordescajas()[i].intersects(this.personaje.getBordes())) {
                this.choca = true;
            }
        }
        for (int i = 0; i < this.mapa.getChuzos().length; i++) {
               if (this.mapa.getBordeschuzos()[i].intersects(this.personaje.getBordes())) {
                   bmoneda=true;
               }
        }
        if(bmoneda){
               if(this.vidas>0){
                this.mapa.setX(0);
                this.personaje.setX(0);
                this.personaje.setY(625);
                this.vidas--;
                
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"FIN DEL JUEGO"); 
                       this.timer.stop();
                   }
        }
        for (int i = 0; i < this.mapa.getBordesmonedas().length; i++) {
             Thread sonido= new Thread(new SonidoMoneda());
            if (this.personaje.getBordes().intersects(this.mapa.getBordesmonedas()[i])) {
                sonido.start();
                this.mapa.getMonedas()[i].setFoto(null);
                this.mapa.getMonedas()[i].setX(0);
                this.mapa.getMonedas()[i].setY(0);
                this.puntaje++;
            }
        }
        if(this.mapa.getBordebandera().intersects(this.personaje.getBordes())){
           this.Estado=2;
           this.personaje.setY(625);
           this.personaje.setX(0);
           this.choca=false;
        }
       
    }
        else if(this.Estado==2){
            bmoneda=false;
                    this.mapa2.bordes();
        this.mapa2.setBordebandera(new Rectangle(this.mapa2.getBandera().getX()+this.mapa2.getX()-30,this.mapa2.getBandera().getY(),
        150,138));
        this.personaje.setBordes(new Rectangle(this.personaje.getX()+22, this.personaje.getY(), 50, 95));
        for (Moneda moneda : this.mapa2.getMonedas()) {
            moneda.setBordes(new Rectangle(moneda.getX() + this.mapa2.getX(), moneda.getY(), 32, 32));
        }
            for (Rectangle bordescaja : this.mapa2.getBordescajas()) {
                if (bordescaja.intersects(this.personaje.getBordes())) {
                    this.choca = true;
                }
            }
        for (int i = 0; i < this.mapa2.getChuzos().length; i++) {
               if (this.mapa2.getBordeschuzos()[i].intersects(this.personaje.getBordes())) {
                   bmoneda=true;
               }
        }
        if(bmoneda){
               if(this.vidas>0){
                this.mapa2.setX(0);
                this.personaje.setX(0);
                this.personaje.setY(625);
                this.vidas--;
                
                   }
                   else{
                       JOptionPane.showMessageDialog(this,"FIN DEL JUEGO"); 
                       this.timer.stop();
                   }
        }
        for (int i = 0; i < this.mapa2.getBordesmonedas().length; i++) {
             Thread sonido= new Thread(new SonidoMoneda());
            if (this.personaje.getBordes().intersects(this.mapa2.getBordesmonedas()[i])) {
                sonido.start();
                this.mapa2.getMonedas()[i].setFoto(null);
                this.mapa2.getMonedas()[i].setX(0);
                this.mapa2.getMonedas()[i].setY(0);
                this.puntaje++;
            }
        }
        if(this.mapa2.getBordebandera().intersects(this.personaje.getBordes())){
            JOptionPane.showMessageDialog(this, "FELICITACIONES");
            System.exit(0);
        }
       
        }
         return this.choca;
    }

    
    public void actualizar() {
        teclado.actualizar();
        if (!teclado.abajo && !teclado.izquierda && !teclado.derecha) {
            this.personaje.setXsprite(0);
            this.personaje.setYsprite(0);
        }
//        if(teclado.arriba){
//            System.out.println("ARRIBA");
//            this.personaje.setY(this.personaje.getY()-10);
//        }

        if (teclado.abajo) {
            System.out.println("ABAJO");
            this.personaje.setXsprite(1);
            this.personaje.setYsprite(2);
            this.personaje.setX(this.personaje.getX() + 2);
            this.personaje.setY(this.personaje.getY() + 2);
            
            if (colisionar()) {
                this.personaje.setX(this.personaje.getX() - 2);
                this.personaje.setY(this.personaje.getY() - 2);
                
            }

            this.choca = false;
        }

        if (teclado.izquierda) {
            this.personaje.retroceder();
            System.out.println("IZQUIERDA");
            this.personaje.setX(this.personaje.getX() - 2);
            if (colisionar()) {
                this.personaje.setX(this.personaje.getX() + 2);
            }
            System.out.println(this.personaje.getX()+this.mapa.getX());
            System.out.println(this.personaje.getY());
            this.choca = false;
        }

        if (teclado.derecha) {
            this.personaje.avanzar();
            System.out.println("DERECHA");
            this.personaje.setX(this.personaje.getX() + 2);
            if (colisionar()) {
                this.personaje.setX(this.personaje.getX() - 2);
            } else {
                camara();
            }
                        System.out.println(this.personaje.getX());
            System.out.println(this.personaje.getY());
            this.choca = false;
        }


        //SALTO
        //Si el estado es cero revisa si el La tecla salto fue activada, 

            
               if (saltoEstado == 0) {
                   if (teclado.space == 9999) {
                teclado.space = 0; //Devolvemos la variable space a 0 para saber que ya tomamos ese salto
                saltoEstado = 1; //Iniciamos el salto
                alturaInicial = this.personaje.getY(); // Capturamos la altura del personaje cuando inicia el salto
            }
        } else if (saltoEstado == 1) {
                this.personaje.setXsprite(7);
                this.personaje.setYsprite(0);
                if (altura <= 85) { // Si no se ah llegado al limite del salto, sigue saltando
                    altura = altura + 4; //Aumentamo la altura
                    this.personaje.setY(alturaInicial - altura); //Moficiacmos
                } else {
                    saltoEstado = 2; //Si ya esta muy alto lo comenzamos a bajar
                }
            } else if (saltoEstado == 2) {
                    if (altura > 0) {
                        //Si esta bajando y aun no ha vuelto a la posicion inicial, lo seguimos bajando
                        altura = altura - 4;
                        this.personaje.setY(alturaInicial - altura);
                        if (colisionar()) {
                            altura = 0;
                        }
                    } else { //Si ya bajo, lo mismo que habia subido, acabamos el salto
                        saltoEstado = 0;
                        }
                    }

            if(this.saltoEstado==0){
                if(!colisionar()&&(this.personaje.getY()<624)){
                     this.personaje.setY(this.personaje.getY() +4);
                } if(colisionar()){
                    this.personaje.setY(this.personaje.getY()-4);
                }
            }
    }
           

        

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.Estado==1){
        for (int i = 0; i < this.mapa.getMonedas().length; i++) {
            this.mapa.getMonedas()[i].movermoneda();
        }
        this.mapa.getBandera().moverbandera();
        }
        else if(this.Estado==2){
        for (int i = 0; i < this.mapa2.getMonedas().length; i++) {
            this.mapa2.getMonedas()[i].movermoneda();
        }
        this.mapa2.getBandera().moverbandera();
        }
        actualizar();
        repaint();
    }

}

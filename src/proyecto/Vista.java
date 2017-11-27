/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Vista extends JPanel implements ActionListener {

    private Personaje personaje;
    private Timer timer;
    private Moneda moneda;
    private EventosTeclado teclado;
    private Mapa mapa;
    private int base=625;
    private boolean choca = false;
    private int altura;
    private int alturaInicial;
    private int saltoEstado;
    public Vista() {
        this.timer = new Timer(20, this);
        this.moneda = new Moneda(650, 480);
        this.personaje = new Personaje(0, 625);
        this.teclado = new EventosTeclado();
        this.mapa = new Mapa();
        this.altura=0;
        this.saltoEstado=0;
        addKeyListener(this.teclado);
        setFocusable(true);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.mapa.getFoto(), this.mapa.getX(), this.mapa.getY(), this);
        for (Caja caja :this.mapa.getCajas()) {
            g.drawImage(caja.getFoto(),caja.getX()+this.mapa.getX(),caja.getY(), this);
        }
       
        g.drawImage(this.personaje.getImagen(), this.personaje.getX(), this.personaje.getY() - 10,
                this.personaje.getX() + 92, this.personaje.getY() + 100,
                (this.personaje.getXsprite() * 46), (this.personaje.getYsprite() * 50),
                ((this.personaje.getXsprite() * 46) + 46), ((this.personaje.getYsprite() * 50) + 50), this);

        g.drawImage(this.moneda.getFoto(), this.moneda.getX()+this.mapa.getX(), this.moneda.getY(),this.moneda.getX()+this.mapa.getX() + 32,
                this.moneda.getY() + 32, (16 * this.moneda.getXsprite()), 0, (16 + (this.moneda.getXsprite() * 16)),
                16, this);

    }
    public void camara(){
        this.mapa.setX(this.mapa.getX()-1);
    }
    public boolean colisionar() {
        this.mapa.bordes();
        this.moneda.setBordes(new Rectangle(this.moneda.getX()+this.mapa.getX(), this.moneda.getY(),32,32));
        this.personaje.setBordes(new Rectangle(this.personaje.getX(),this.personaje.getY(),85,95));
        for (int i = 0; i < this.mapa.getBordes().length; i++) {
            if (this.mapa.getBordes()[i].intersects(this.personaje.getBordes())) {
                this.choca = true;
            }
        }
        if(this.personaje.getBordes().intersects(this.moneda.getBordes())){
            this.moneda.setFoto(null);
            this.moneda.setBordes(new Rectangle(0,0,0,0));
        }
        return this.choca;
    }
    public void gravedad(){
      while(!colisionar()){
         this.personaje.setY(this.personaje.getY()+1);
      }
      this.personaje.setY(this.personaje.getY()-1);
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
            if (colisionar()) {
                this.personaje.setX(this.personaje.getX() - 2);
            }
            this.choca = false;
        }

        if (teclado.izquierda) {
            System.out.println("IZQUIERDA");
            this.personaje.setX(this.personaje.getX() - 2);
            if (colisionar()) {
                this.personaje.setX(this.personaje.getX() + 2);
            }
            else{
                gravedad();
            }
            this.choca = false;
        }

        if (teclado.derecha) {
            this.personaje.avanzar();
            System.out.println("DERECHA");
            this.personaje.setX(this.personaje.getX() + 2);
            if (colisionar()) {
                this.personaje.setX(this.personaje.getX() - 2);
            }
            else{
            gravedad();
            camara();
            }
            this.choca = false;
        }
        //SALTO
         //Si el estado es cero revisa si el La tecla salto fue activada, 
            if (teclado.space==9999) { 
                if (saltoEstado == 0) {
                if(!colisionar()){
                if(this.personaje.getY()<this.base){
                this.personaje.setY(this.personaje.getY()+1);
                }
                }
                teclado.space =0; //Devolvemos la variable space a 0 para saber que ya tomamos ese salto
                saltoEstado=1; //Iniciamos el salto
                alturaInicial = this.personaje.getY(); // Capturamos la altura del personaje cuando inicia el salto
            }
        } else {
            if (saltoEstado == 1) {
                this.personaje.setXsprite(7);
                this.personaje.setYsprite(0);
                if (altura <= 85) { // Si no se ah llegado al limite del salto, sigue saltando
                    altura = altura + 4; //Aumentamo la altura
                    this.personaje.setY(alturaInicial - altura); //Moficiacmos
                } else {
                    saltoEstado = 2; //Si ya esta muy alto lo comenzamos a bajar
                }
            } else {
                if (saltoEstado == 2) { 
                    if (altura > 0) {
                         //Si esta bajando y aun no ha vuelto a la posicion inicial, lo seguimos bajando
                        altura = altura - 4;
                        this.personaje.setY(alturaInicial - altura);
                        if(colisionar()){
                            altura=0;
                            this.personaje.setY(this.personaje.getY()-4);
                            
                        }
                    } else { //Si ya bajo, lo mismo que habia subido, acabamos el salto
                        saltoEstado = 0;
                    }
                    
                }
            }
        }
    }
    @Override
        public void actionPerformed(ActionEvent e) {
        this.moneda.movermoneda();
        actualizar();
        repaint();
    }
    
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Vista extends JFrame implements Runnable {
private boolean Running=false;
private int aps=0;
private int fps=0;
private EventosTeclado teclado;
private Visual visual;
private Mapa mapa;
private int contadornuevo=0;
private int colisiones=0;
private boolean intersectaenemigo=false;
    public Vista() {
        this.teclado = new EventosTeclado();
        this.visual=new Visual();
        this.mapa= new Mapa();
        addKeyListener(this.teclado);
        setFocusable(true);
    }

    public void iniciar(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1920,1080));
        this.Running=true;
}

    public boolean colisionar(){
        boolean si=false;
        this.visual.getMoneda().setBordes(new Rectangle(this.visual.getMoneda().getX(),this.visual.getMoneda().getY(),
        this.visual.getMoneda().getX()+16,
                this.visual.getMoneda().getY()+16));
        this.visual.getPersonaje().setBordes(new Rectangle(this.visual.getPersonaje().getX()+20,
                this.visual.getPersonaje().getY()-10,55,100));
    for (Rectangle borde : this.mapa.getBordes()) {
        if (this.visual.getPersonaje().getBordes().intersects(borde)) {
            this.colisiones++;
            si=true;    
        }
    }
        if(this.visual.getPersonaje().getBordes().intersects(this.visual.getMoneda().getBordes())) {
            this.intersectaenemigo=true;
        }
        return si;
    }
    public void camara(){

        if(this.visual.getPersonaje().getX()>=0){
            this.mapa.bordes();
            this.mapa.setX(this.mapa.getX()-2);
            this.visual.getMoneda().setX(this.visual.getMoneda().getX()-2);
        }

    }
    public void actualizar(){ 
        teclado.actualizar();

        this.visual.moneda();
        this.visual.enemigo();
        if(!teclado.arriba&&!teclado.abajo&&!teclado.izquierda&&!teclado.derecha){
            this.visual.getPersonaje().setXsprite(0);
            this.visual.getPersonaje().setYsprite(0);
        }
        if(teclado.arriba){
            this.visual.getPersonaje().setY(this.visual.getPersonaje().getY()-70);
            if(colisionar()){
            this.visual.getPersonaje().setY(this.visual.getPersonaje().getY()+2);
            }
        }
        
        if(teclado.abajo){
        
        this.visual.getPersonaje().setXsprite(1);
        this.visual.getPersonaje().setYsprite(2);
        this.visual.getPersonaje().setX(this.visual.getPersonaje().getX()+2);
        System.out.println(this.visual.getPersonaje().getY());
        System.out.println(this.visual.getPersonaje().getX());
        if((colisionar())&&(this.colisiones>2)){
        this.visual.getPersonaje().setY(this.visual.getPersonaje().getY()-2);
        this.visual.getPersonaje().setX(this.visual.getPersonaje().getX()-2);
        }

        }
        
        if(teclado.izquierda){  
        this.visual.getPersonaje().setX(this.visual.getPersonaje().getX()-2);
        this.visual.caminar();
        if(colisionar()){
           
                this.visual.getPersonaje().setX(this.visual.getPersonaje().getX()+2);
            }
            }
        
        if(teclado.derecha){
                    camara();
        this.visual.getPersonaje().setX(this.visual.getPersonaje().getX()+2);
        this.visual.caminar();  

        if(colisionar()){
                this.visual.getPersonaje().setX(this.visual.getPersonaje().getX()-2);
            }
            if(this.intersectaenemigo){
                this.visual.getMoneda().setFoto(null);
            }

        }
        this.aps++;
                while(!colisionar()){
        this.visual.getPersonaje().setY(this.visual.getPersonaje().getY()+1);
        }
        this.visual.getPersonaje().setY(this.visual.getPersonaje().getY()-1);
        for (int i = 0; i < 100; i++) {
            this.visual.repaint();
        }

    }
    
    
        public void mostrar(){
        Graphics g=getGraphics();
        visual.paintComponent(g);
        mapa.paintComponent(g);
        this.fps++;
        }
    @Override
    public void run() {
        iniciar();
        int NS_Segundo=1000000000;
        byte APS_OBJETIVO=60;
        double NS_Actualizacion=NS_Segundo/APS_OBJETIVO;
        long referencia_actualizacion=System.nanoTime();
        long referencia_contador=System.nanoTime();
        double tiempotranscurrido;
        double delta=0;
        requestFocus();
        while(this.Running){
        long iniciobucle=System.nanoTime();
        tiempotranscurrido=iniciobucle-referencia_actualizacion;
        referencia_actualizacion=iniciobucle;
        delta+=tiempotranscurrido/NS_Actualizacion;
        while(delta>=1){
        actualizar();    
        delta--;
        }
        mostrar();
        if(System.nanoTime()-referencia_contador>NS_Segundo){
        this.setTitle("APS: "+this.aps+ " FPS: "+this.fps);
        this.aps=0;
        this.fps=0;
        referencia_contador=System.nanoTime();
        }
    }   
    }
    
}

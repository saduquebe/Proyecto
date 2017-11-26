/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author User
 */
public class EventosTeclado implements KeyListener{
private final int teclas=120;
private boolean keys[];

public boolean arriba;
public boolean abajo;
public boolean izquierda;
public boolean derecha;

//Esto lo hago solamente por que tuve problemas con el KeyType

public int space;


    public EventosTeclado() {
        this.keys = new boolean[teclas];
        this.space= 0;
    }

public void actualizar(){
    this.arriba=this.keys[KeyEvent.VK_UP];
    this.abajo=this.keys[KeyEvent.VK_DOWN];
    this.izquierda=this.keys[KeyEvent.VK_LEFT];
    this.derecha=this.keys[KeyEvent.VK_RIGHT];
}

    @Override
    public void keyReleased(KeyEvent e) {
     this.keys[e.getKeyCode()]=false;
        if(e.getKeyCode() == 32){
            this.space=9999;
        } 
        else {
        }
        
    }
        @Override
    public void keyPressed(KeyEvent e) {
        this.keys[e.getKeyCode()]=true;
        if(e.getKeyCode() == 32){
            this.space++;
        } 
        else {
            this.space=0;
        }
        
        
    }
    
    //CAMILO
    @Override
    public void keyTyped(KeyEvent e) {
    }
}

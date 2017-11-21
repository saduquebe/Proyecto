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

    public EventosTeclado() {
        this.keys = new boolean[teclas];
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
    }
        @Override
    public void keyPressed(KeyEvent e) {
        this.keys[e.getKeyCode()]=true;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}

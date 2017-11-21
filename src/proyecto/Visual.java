/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Visual extends JPanel {
private Personaje personaje;
private Mapa mapa;
private int base;
private Image fondo;
public int contador=0;
public int contadorsaltar=0;
    public Visual() {
        this.personaje = new Personaje(0,634);
        this.base=684;
        this.fondo= Toolkit.getDefaultToolkit().getImage("layer-1.png");
    }
@Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);

                g.drawImage(this.personaje.getImagen(),this.personaje.getX(),this.personaje.getY()-10,
                this.personaje.getX()+92,this.personaje.getY()+100,
                (this.personaje.getXsprite()*46),(this.personaje.getYsprite()*50),
                ((this.personaje.getXsprite()*46)+46),((this.personaje.getYsprite()*50)+50),this);    
    }
    public Personaje getPersonaje() {
        return personaje;
    }
    public void caminar(){
        if(contador==6){
        this.personaje.setYsprite(3);
        if(this.personaje.getXsprite()<7){
        this.personaje.setXsprite(this.personaje.getXsprite()+1);
        }
        else{
            this.personaje.setXsprite(0);
            
        }
        contador=0;
        }
        else{contador++;}
    }
    
    public void saltar(){
        if(this.contadorsaltar<=30){
            this.personaje.setXsprite(6);
            this.personaje.setYsprite(0);
            this.contadorsaltar++;
        }
        else if (this.contadorsaltar<=50){
            this.personaje.setXsprite(1);
            this.personaje.setYsprite(0);
            this.contadorsaltar++;
        }
        else{
            this.contadorsaltar=0;
        }
        }
    

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author User
 */
public class Personaje extends Ente{
    private int auxx;
    private int contadora=0;
    private int contadorb=0;
    private int xsprite;
    private int ysprite;
    private Rectangle bordes;
    private Image imagen;
    public Personaje(int x, int y) {
        super(x, y);
        this.auxx=0;
        this.xsprite=0;
        this.ysprite=0;
        this.imagen=Toolkit.getDefaultToolkit().getImage("player-spritemap-v9.png");
        this.bordes= new Rectangle(this.getX(),this.getY(),80,95);
    }
    public void avanzar(){
        if(contadora==2){
        this.ysprite=3;
        if(this.xsprite<7){
        this.xsprite=this.xsprite+1;
        }
        else{
            this.xsprite=0;
            
        }
        contadora=0;
        }
        else{contadora++;}
    }
    public void retroceder(){
        if(contadorb==2){
        this.ysprite=3;
        if((this.xsprite<=7)&&(this.xsprite>=0)){
        this.xsprite=this.xsprite-1;
        }
        else{
            this.xsprite=7;
            
        }
        contadorb=0;
        }
        else{contadorb++;}
    }
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public int getXsprite() {
        return xsprite;
    }

    public void setXsprite(int xsprite) {
        this.xsprite = xsprite;
    }

    public int getYsprite() {
        return ysprite;
    }

    public void setYsprite(int ysprite) {
        this.ysprite = ysprite;
    }

    public Rectangle getBordes() {
        return bordes;
    }

    public void setBordes(Rectangle bordes) {
        this.bordes = bordes;
    }
    
    
}
